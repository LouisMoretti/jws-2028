package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.MapConverter;
import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.*;
import fr.epita.assistants.yakamon.domain.entity.CatchEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.Point;
import fr.epita.assistants.yakamon.utils.tile.Collectible;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import fr.epita.assistants.yakamon.utils.tile.YakamonInfo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static fr.epita.assistants.yakamon.utils.tile.CollectibleType.YAKAMON;
import static fr.epita.assistants.yakamon.utils.tile.ItemType.NONE;
import static fr.epita.assistants.yakamon.utils.tile.ItemType.YAKABALL;

@ApplicationScoped
public class CatchService {
    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    MapConverter mapConverter;

    @Inject
    ItemRepository itemRepository;

    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    YakamonConverter yakamonConverter;

    @ConfigProperty(name = "JWS_TICK_DURATION")
    Integer jwsTickDuration;

    @ConfigProperty(name = "JWS_CATCH_DELAY")
    Integer jwsCatchDelay;

    public YakamonEntity catchYakamon() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        if (itemRepository.yakaballAmount() < 1) ErrorCode.NOT_ENOUGH_YAKABALLS_ERROR.throwException();
        if (yakamonRepository.yakamonCount() >= 3) ErrorCode.TEAM_IS_FULL_ERROR.throwException();

        PlayerModel player = playerRepository.getPlayer();
        LocalDateTime now = LocalDateTime.now();
        if ((player.lastCatch != null) && (player.lastCatch.isAfter(now.minus(((long) jwsTickDuration * jwsCatchDelay),
                ChronoUnit.MILLIS)))) {
            ErrorCode.TOO_MANY_REQUESTS_ERROR.throwException();
        }

        String mapString = gameRepository.getMap();
        List<List<TileType>> map = mapConverter.stringToMatrix(mapString);

        Point pos = new Point(player.getPosX(), player.getPosY());
        Collectible collectible = map.get(pos.getPosY()).get(pos.getPosX()).getCollectible();
        if (!collectible.getCollectibleType().equals(YAKAMON)) {
            ErrorCode.NO_YAKAMON_AT_POS_ERROR.throwException();
        }

        YakamonInfo yakamonInfo = (YakamonInfo) collectible.getCollectibleInfo();
        int yakadexId = yakamonInfo.getYakadexId();

        YakadexEntryModel yakadexEntryModel = yakadexEntryRepository.getEntryById(yakadexId);

        YakamonModel yakamonModel = new YakamonModel();
        yakamonModel.setNickname(yakadexEntryModel.getName());
        yakamonModel.setYakadexEntry(yakadexEntryModel);
        yakamonModel.setEnergyPoints(0);

        yakamonRepository.addYakamon(yakamonModel);
        itemRepository.removeItem(1, YAKABALL);
        yakadexEntryRepository.setCaughtStateById(yakadexId);
        playerRepository.updateLastCatch(now);

        map.get(pos.getPosY()).get(pos.getPosX()).setCollectible(NONE);
        mapString = mapConverter.matrixToString(map);
        gameRepository.updateMap(mapString);

        YakamonModel yakamonModel1 =
                yakamonRepository.getYakamons().filter(yakamonModelFilter -> yakamonModelFilter.getYakadexEntry().getId() == yakadexId).findFirst().get();
        return yakamonConverter.modelToEntity(yakamonModel1);
    }

}
