package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.utils.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class InventoryEntity {
    private List<Item> items;
}
