package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class TeamService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    YakamonConverter yakamonConverter;

    public YakamonTeamEntity getTeam() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        // Get list of yakamons
        Stream<YakamonModel> yakamonModelStream = yakamonRepository.getYakamons();
        List<YakamonEntity> yakamonEntityList = yakamonModelStream
                .map(yakamonModel -> yakamonConverter.modelToEntity(yakamonModel))
                .toList();

        return new YakamonTeamEntity(yakamonEntityList);
    }
}
