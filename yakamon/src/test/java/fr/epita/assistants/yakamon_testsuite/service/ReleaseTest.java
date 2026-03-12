package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.service.ReleaseService;
import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class ReleaseTest {
    @Inject
    ReleaseService releaseService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            releaseService.release(UUID.randomUUID().toString());
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            releaseService.release(UUID.randomUUID().toString());
        } catch (Exception e) {
            assertEquals("HTTP 404 Not Found", e.getMessage());
        }
    }
}
