package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.ItemModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<ItemModel> {
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

    public Stream<ItemModel> getAllItems() {
        return findAll().stream();
    }
}
