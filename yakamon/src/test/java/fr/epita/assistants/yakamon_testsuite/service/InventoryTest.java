package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.domain.service.GameService;
import fr.epita.assistants.yakamon.domain.service.InventoryService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class InventoryTest {
    @Inject
    InventoryService inventoryService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            inventoryService.getInventory();
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        InventoryEntity inventory = inventoryService.getInventory();
        assertEquals(1, inventory.getItems().size());
        assertEquals(5, inventory.getItems().get(0).getQuantity());
    }
}
