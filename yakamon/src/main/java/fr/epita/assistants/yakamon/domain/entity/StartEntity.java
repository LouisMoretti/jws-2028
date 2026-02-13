package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.utils.tile.TileType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StartEntity {
    private List<List<TileType>> map;
}
