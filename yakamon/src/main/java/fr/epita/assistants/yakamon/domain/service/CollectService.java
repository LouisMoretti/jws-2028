package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.ItemConverter;
import fr.epita.assistants.yakamon.converter.MapConverter;
import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.ItemRepository;
import fr.epita.assistants.yakamon.data.repository.PlayerRepository;
import fr.epita.assistants.yakamon.domain.entity.CollectEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.Item;
import fr.epita.assistants.yakamon.utils.Point;
import fr.epita.assistants.yakamon.utils.tile.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static fr.epita.assistants.yakamon.utils.tile.CollectibleType.ITEM;
import static fr.epita.assistants.yakamon.utils.tile.CollectibleType.YAKAMON;
import static fr.epita.assistants.yakamon.utils.tile.ItemType.NONE;
import static fr.epita.assistants.yakamon.utils.tile.ItemType.YAKABALL;

@ApplicationScoped
public class CollectService {
    @Inject
    GameRepository gameRepository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    ItemConverter itemConverter;

    @Inject
    MapConverter mapConverter;

    @ConfigProperty(name = "JWS_TICK_DURATION")
    Integer jwsTickDuration;

    @ConfigProperty(name = "JWS_COLLECT_DELAY")
    Integer jwsCollectDelay;

    @ConfigProperty(name = "JWS_COLLECT_MULTIPLIER")
    Integer jwsCollectMultiplier;

    public CollectEntity collect() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        PlayerModel player = playerRepository.getPlayer();
        LocalDateTime now = LocalDateTime.now();
        if ((player.lastMove != null) && (player.lastMove.isAfter(now.minus(((long) jwsTickDuration * jwsCollectDelay),
                ChronoUnit.MILLIS)))) {
            ErrorCode.TOO_MANY_REQUESTS_ERROR.throwException();
        }

        String mapString = gameRepository.getMap();
        List<List<TileType>> map = mapConverter.stringToMatrix(mapString);

        Point pos = new Point(player.getPosX(), player.getPosY());
        Collectible collectible = map.get(pos.getPosY()).get(pos.getPosX()).getCollectible();
        if (!collectible.getCollectibleType().equals(ITEM)
        || ((ItemType)collectible).equals(NONE)) {
            ErrorCode.NO_ITEM_AT_POS_ERROR.throwException();
        }

        ItemType itemType = (ItemType) collectible;

        ItemModel itemModel = new ItemModel();
        itemModel.setType(itemType);
        itemModel.setQuantity(jwsCollectMultiplier);
        itemRepository.addItem(itemModel);

        map.get(pos.getPosY()).get(pos.getPosX()).setCollectible(NONE);
        mapString = mapConverter.matrixToString(map);
        gameRepository.updateMap(mapString);
        
        return new CollectEntity(map.get(pos.getPosY()).get(pos.getPosX()));
    }
}
