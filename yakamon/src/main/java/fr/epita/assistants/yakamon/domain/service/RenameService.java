package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RenameService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    YakamonConverter yakamonConverter;

    public YakamonEntity rename(RenameEntity renameEntity) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        String newNickname = renameEntity.getNewNickname();
        if (newNickname == null || newNickname.isEmpty() || newNickname.length() > 20) {
            ErrorCode.INVALID_NAME_ERROR.throwException();
        }

        YakamonModel yakamon = yakamonRepository.updateName(renameEntity.getUuid(), newNickname);
        return yakamonConverter.modelToEntity(yakamon);
    }
}
