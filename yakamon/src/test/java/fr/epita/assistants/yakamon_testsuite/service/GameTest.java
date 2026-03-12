package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.service.GameService;
import fr.epita.assistants.yakamon.domain.entity.GameEntity;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class GameTest {
    @Inject
    GameService gameService;

    @Test
    public void basicTest() {
        GameEntity game = gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        assertEquals(11, game.getMap().size());
        for (int i = 0; i < game.getMap().size(); i++) {
            assertEquals(21, game.getMap().get(i).size());
        }
    }

    @Test
    public void nullMapTest() {
        try {
            gameService.startLogic("LeTigre", "null");
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }
}
