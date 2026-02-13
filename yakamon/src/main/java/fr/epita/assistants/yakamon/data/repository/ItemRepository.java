package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.converter.ItemConverter;
import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.utils.Item;
import fr.epita.assistants.yakamon.utils.tile.ItemType;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<ItemModel> {
    @Inject
    ItemConverter itemConverter;

    @Transactional
    public void addItem(ItemModel item) {
        Optional<ItemModel> optionalItem = find("type", item.type).singleResultOptional();
        if (optionalItem.isEmpty()) {
            // Create item in table
            persist(item);
        } else {
            // Update item in table
            ItemModel itemModel = optionalItem.get();
            Integer baseQuantity = itemModel.getQuantity();
            itemModel.setQuantity(baseQuantity + item.getQuantity());
        }
    }

    public List<Item> getAllItems() {
        PanacheQuery<ItemModel> itemModelPanacheQuery = findAll();
        Stream<ItemModel> itemModelList = itemModelPanacheQuery.stream();
        return itemModelList.map(itemModel -> itemConverter.itemModelToItem(itemModel)).toList();
    }
}
