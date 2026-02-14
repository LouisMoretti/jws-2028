package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.ItemRepository;
import fr.epita.assistants.yakamon.data.repository.PlayerRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.tile.ItemType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class FeedService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    YakamonConverter yakamonConverter;

    @ConfigProperty(name = "JWS_TICK_DURATION")
    Integer jwsTickDuration;

    @ConfigProperty(name = "JWS_FEED_DELAY")
    Integer jwsFeedDelay;

    public YakamonEntity feed(FeedEntity feedEntity) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        PlayerModel player = playerRepository.getPlayer();
        LocalDateTime now = LocalDateTime.now();
        if ((player.lastFeed != null) && (player.lastFeed.isAfter(now.minus(((long) jwsTickDuration * jwsFeedDelay), ChronoUnit.MILLIS)))) {
            ErrorCode.TOO_MANY_REQUESTS_ERROR.throwException();
        }

        if (itemRepository.scroogeAmount() < feedEntity.getQuantity()){
            ErrorCode.NOT_ENOUGH_SCROOGE_ERROR.throwException();
        }

        itemRepository.removeItem(feedEntity.getQuantity(), ItemType.SCROOGE);
        yakamonRepository.addEnergyFromUuid(feedEntity.getUuid(), feedEntity.getQuantity());
        playerRepository.updateLastFeed(now);

        YakamonModel yakamon = yakamonRepository.getYakamonFromUUID(feedEntity.getUuid());
        return yakamonConverter.modelToEntity(yakamon);
    }
}
