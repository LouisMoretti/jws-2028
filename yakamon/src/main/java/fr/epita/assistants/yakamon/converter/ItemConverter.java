package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.utils.Item;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang.NotImplementedException;

@ApplicationScoped
public class ItemConverter {
    public Item itemModelToItem(ItemModel itemModel) {
        return new Item(itemModel.getType(), itemModel.getQuantity());
    }
}
