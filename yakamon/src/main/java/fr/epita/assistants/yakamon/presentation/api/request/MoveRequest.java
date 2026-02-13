package fr.epita.assistants.yakamon.presentation.api.request;

import fr.epita.assistants.yakamon.utils.Direction;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MoveRequest {
    private Direction direction;
}
