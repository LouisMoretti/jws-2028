package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.ItemRepository;
import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.utils.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

@ApplicationScoped
public class InventoryService {
    @Inject
    GameRepository gameRepository;

    @Inject
    ItemRepository itemRepository;

    public InventoryEntity getInventory() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        // Get list of items
        List<Item> items = itemRepository.getAllItems();

        return new InventoryEntity(items);
    }
}
