package fr.epita.assistants.yakamon.presentation.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StartRequest {
    private String mapPath;
    private String playerName;
}
