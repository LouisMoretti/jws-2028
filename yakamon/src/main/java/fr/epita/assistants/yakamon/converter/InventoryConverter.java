package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.presentation.api.response.InventoryResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang.NotImplementedException;

@ApplicationScoped
public class InventoryConverter {
    public InventoryResponse entityToResponse(InventoryEntity inventoryEntity) {
        if (inventoryEntity == null) return null;
        return new InventoryResponse(inventoryEntity.getItems());
    }
}
