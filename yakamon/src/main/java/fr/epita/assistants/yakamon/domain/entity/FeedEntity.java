package fr.epita.assistants.yakamon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class FeedEntity {
    private UUID uuid;
    private Integer quantity;
}
