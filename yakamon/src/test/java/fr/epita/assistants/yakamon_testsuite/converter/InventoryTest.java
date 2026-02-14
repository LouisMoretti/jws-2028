package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.InventoryConverter;
import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.presentation.api.response.InventoryResponse;
import fr.epita.assistants.yakamon.utils.Item;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class InventoryTest {
    @Inject
    InventoryConverter inventoryConverter;

    @Test
    public void basicTest() {
        List<Item> items = new ArrayList<>();
        InventoryEntity entity = new InventoryEntity(items);

        InventoryResponse response = inventoryConverter.entityToResponse(entity);
        assertEquals(response.getItems(), items);
    }

    @Test
    public void nullTest() {
        assertNull(inventoryConverter.entityToResponse(null));
    }
}
