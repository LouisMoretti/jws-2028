package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class FeedConverter {
    public FeedEntity requestToEntity(String uuid, FeedRequest request) {
        if (uuid == null || request == null) return null;
        return new FeedEntity(UUID.fromString(uuid), request.getQuantity());
    }
}
