package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonTeamResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class YakamonTeamConverter {
    @Inject
    YakamonConverter yakamonConverter;

    public YakamonTeamResponse entityToResponse(YakamonTeamEntity yakamonTeam) {
        if (yakamonTeam == null) return null;
        return new YakamonTeamResponse(yakamonTeam
                .getYakamons()
                .stream()
                .map(yakamonConverter::entityToResponse)
                .toList()
        );
    }
}
