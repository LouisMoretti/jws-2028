package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.domain.service.MoveService;
import fr.epita.assistants.yakamon.utils.Direction;
import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class MoveTest {
    @Inject
    MoveService moveService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            moveService.movePlayer(Direction.DOWN);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        MoveEntity move = moveService.movePlayer(Direction.DOWN);
        assertEquals(0, move.getPosition().getPosX());
        assertEquals(1, move.getPosition().getPosY());
    }

    @Test
    public void basic2Test() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            moveService.movePlayer(Direction.UP);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }
}
