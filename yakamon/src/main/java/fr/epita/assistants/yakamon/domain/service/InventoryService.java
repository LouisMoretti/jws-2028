package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.ItemConverter;
import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.ItemRepository;
import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.utils.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class InventoryService {
    @Inject
    GameRepository gameRepository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    ItemConverter itemConverter;

    public InventoryEntity getInventory() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        // Get list of items
        Stream<ItemModel> itemModelStream = itemRepository.getAllItems();
        List<Item> items = itemModelStream.map(itemModel -> itemConverter.itemModelToItem(itemModel)).toList();

        return new InventoryEntity(items);
    }
}
