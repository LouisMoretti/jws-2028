package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.MapConverter;
import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.PlayerRepository;
import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.utils.Direction;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.Point;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
public class MoveService {
    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    MapConverter mapConverter;

    @ConfigProperty(name = "JWS_TICK_DURATION")
    Integer jwsTickDuration;

    @ConfigProperty(name = "JWS_MOVEMENT_DELAY")
    Integer jwsMovementDelay;

    public MoveEntity movePlayer(Direction direction) {
        if (direction == null)
            ErrorCode.INVALID_DIRECTION_ERROR.throwException();

        // Check if game is started.
        gameRepository.checkGameExistence();

        PlayerModel player = playerRepository.getPlayer();
        LocalDateTime now = LocalDateTime.now();
        if ((player.lastMove != null) && (player.lastMove.isAfter(now.minus(((long) jwsTickDuration * jwsMovementDelay), ChronoUnit.MILLIS)))) {
            ErrorCode.TOO_MANY_REQUESTS_ERROR.throwException();
        }

        String mapString = gameRepository.getMap();
        List<List<TileType>> map = mapConverter.stringToMatrix(mapString);

        // Check new position.
        // TODO: Advanced move.
        Point newPos = new Point(player.getPosX() + direction.getPoint().getPosX(),
                player.getPosY() + direction.getPoint().getPosY());
        if (newPos.getPosX() < 0 || newPos.getPosY() < 0 || newPos.getPosY() >= map.size() || newPos.getPosX() >= map.get(newPos.getPosY()).size()
                || !map.get(newPos.getPosY()).get(newPos.getPosX()).getTerrainType().isWalkable()) {
            ErrorCode.INVALID_DIRECTION_ERROR.throwException();
        }

        // Update player pos in db.
        playerRepository.movePlayer(newPos);
        playerRepository.updateLastMove(now);

        return new MoveEntity(newPos);
    }
}
