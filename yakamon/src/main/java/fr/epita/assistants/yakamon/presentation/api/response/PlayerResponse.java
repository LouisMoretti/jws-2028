package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse {
    private String uuid;
    private String name;
    private Integer poxX;
    private Integer poxY;
    private String lastMove;
    private String lastCollect;
    private String lastCatch;
    private String lastFeed;
}
