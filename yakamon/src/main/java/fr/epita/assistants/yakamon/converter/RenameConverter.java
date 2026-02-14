package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;

import java.util.UUID;

public class RenameConverter {
    public RenameEntity requestToEntity(String uuid, RenameRequest request) {
        return new RenameEntity(UUID.fromString(uuid), request.getNewNickname());
    }
}
