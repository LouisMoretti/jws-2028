package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class RenameService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    YakamonConverter yakamonConverter;

    public YakamonEntity rename(String uuid, RenameRequest renameRequest) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        // TODO; Check new name validity.

        YakamonModel yakamon = yakamonRepository.updateName(UUID.fromString(uuid), renameRequest.getNewNickname());
        return yakamonConverter.modelToEntity(yakamon);
    }
}
