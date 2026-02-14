package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.ItemModel;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.tile.ItemType;
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

    public int yakaballAmount() {
        Optional<ItemModel> optionalItem = find("type", ItemType.YAKABALL).singleResultOptional();
        if (optionalItem.isEmpty()) {
            return 0;
        } else {
            return optionalItem.get().getQuantity();
        }
    }

    @Transactional
    public void removeItem(int i, ItemType itemType) {
        Optional<ItemModel> optionalItem = find("type", itemType).singleResultOptional();
        if (optionalItem.isEmpty()) {
            // TODO; Replace error.
            ErrorCode.EXAMPLE_ERROR.throwException();
        } else {
            ItemModel itemModel = optionalItem.get();
            if (itemModel.getQuantity() < i) {
                // TODO; Replace error.
                ErrorCode.EXAMPLE_ERROR.throwException();
            }

            itemModel.setQuantity(itemModel.getQuantity() - i);
        }
    }
}
