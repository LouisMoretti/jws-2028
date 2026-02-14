package fr.epita.assistants.yakamon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class CatchEntity {
    private UUID uuid;
    private String nickname;
    private Integer yakadexId;
    private Integer energyPoints;
}
