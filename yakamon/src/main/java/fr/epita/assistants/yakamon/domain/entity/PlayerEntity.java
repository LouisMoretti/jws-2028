package fr.epita.assistants.yakamon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class PlayerEntity {
    private UUID uuid;
    private String name;
    private Integer poxX;
    private Integer poxY;
    private LocalDateTime lastMove;
    private LocalDateTime lastCollect;
    private LocalDateTime lastCatch;
    private LocalDateTime lastFeed;
}
