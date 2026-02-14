package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonTeamResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class YakamonTeamConverter {
    private final YakamonConverter yakamonConverter;

    @Inject
    public YakamonTeamConverter(YakamonConverter yakamonConverter) {
        this.yakamonConverter = yakamonConverter;
    }

    public YakamonTeamResponse entityToResponse(YakamonTeamEntity yakamonTeam) {
        return new YakamonTeamResponse(yakamonTeam
                .getYakamons()
                .stream()
                .map(yakamonConverter::entityToResponse)
                .toList()
        );
    }
}
