package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse {
    private UUID uuid;
    private String name;
    private Integer posX;
    private Integer posY;
    private LocalDateTime lastMove;
    private LocalDateTime lastCollect;
    private LocalDateTime lastCatch;
    private LocalDateTime lastFeed;
}
