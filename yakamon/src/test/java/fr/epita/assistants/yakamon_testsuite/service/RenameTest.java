package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.domain.service.GameService;
import fr.epita.assistants.yakamon.domain.service.RenameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class RenameTest {
    @Inject
    RenameService renameService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            RenameEntity entity = new RenameEntity(UUID.randomUUID(), "Tigrou");
            renameService.rename(entity);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            RenameEntity entity = new RenameEntity(UUID.randomUUID(), "Tigrou");
            renameService.rename(entity);
        } catch (Exception e) {
            assertEquals("HTTP 404 Not Found", e.getMessage());
        }
    }

    @Test
    public void invalidNameTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            RenameEntity entity = new RenameEntity(UUID.randomUUID(), null);
            renameService.rename(entity);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }
}
