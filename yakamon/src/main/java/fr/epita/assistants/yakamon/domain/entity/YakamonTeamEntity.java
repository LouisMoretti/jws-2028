package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.presentation.api.response.YakamonResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class YakamonTeamEntity {
    private List<YakamonEntity> yakamons;
}
