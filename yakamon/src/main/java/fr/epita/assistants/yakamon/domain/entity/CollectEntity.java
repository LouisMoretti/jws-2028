package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.utils.tile.TileType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CollectEntity {
    private TileType tile;
}
