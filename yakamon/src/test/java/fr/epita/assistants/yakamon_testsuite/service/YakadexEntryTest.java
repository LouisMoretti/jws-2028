package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.domain.service.GameService;
import fr.epita.assistants.yakamon.domain.service.YakadexEntryService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class YakadexEntryTest {
    @Inject
    YakadexEntryService yakadexEntryService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            yakadexEntryService.getYakadexEntry(1);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void baseTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        YakadexEntryEntity entry = yakadexEntryService.getYakadexEntry(1);
        assertEquals(1, entry.getId());
        assertEquals("Yakimon", entry.getName());
    }

    @Test
    public void notExistingIdTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            yakadexEntryService.getYakadexEntry(0);
        } catch (Exception e) {
            assertEquals("HTTP 404 Not Found", e.getMessage());
        }
    }
}
