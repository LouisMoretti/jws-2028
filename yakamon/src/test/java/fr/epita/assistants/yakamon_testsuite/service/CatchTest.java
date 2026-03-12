package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.service.CatchService;
import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class CatchTest {
    @Inject
    CatchService catchService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            catchService.catchYakamon();
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            catchService.catchYakamon();
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }
}
