package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.ItemConverter;
import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.utils.Item;
import fr.epita.assistants.yakamon.utils.tile.ItemType;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class ItemTest {
    @Inject
    ItemConverter itemConverter;

    @Test
    public void basicTest() {
        ItemModel itemModel = new ItemModel();
        itemModel.type = ItemType.NONE;
        itemModel.quantity = 0;

        Item item = itemConverter.itemModelToItem(itemModel);
        assertEquals(ItemType.NONE, item.getItemType());
        assertEquals(0, item.getQuantity());
    }

    @Test
    public void nullTest() {
        assertNull(itemConverter.itemModelToItem(null));
    }
}
