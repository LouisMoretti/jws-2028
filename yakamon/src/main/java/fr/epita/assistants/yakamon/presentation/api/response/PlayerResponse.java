package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse {
    private UUID uuid;
    private String name;
    private Integer poxX;
    private Integer poxY;
    private LocalDateTime lastMove;
    private LocalDateTime lastCollect;
    private LocalDateTime lastCatch;
    private LocalDateTime lastFeed;
}
