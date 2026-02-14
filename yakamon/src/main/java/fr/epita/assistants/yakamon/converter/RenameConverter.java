package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RenameConverter {
    public RenameEntity requestToEntity(String uuid, RenameRequest request) {
        if (uuid == null || request == null) return null;
        return new RenameEntity(UUID.fromString(uuid), request.getNewNickname());
    }
}
