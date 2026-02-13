package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.utils.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MoveEntity {
    private Point position;
}
