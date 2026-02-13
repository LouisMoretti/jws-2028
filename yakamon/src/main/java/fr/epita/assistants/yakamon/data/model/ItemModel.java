package fr.epita.assistants.yakamon.data.model;

import fr.epita.assistants.yakamon.utils.tile.ItemType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "type"}))
@Getter
@Setter
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public ItemType type;
    public Integer quantity;
}
