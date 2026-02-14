package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.CollectEntity;
import fr.epita.assistants.yakamon.presentation.api.response.CollectResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CollectConverter {
    public CollectResponse entityToResponse(CollectEntity collectEntity) {
        if (collectEntity == null) return null;
        return new CollectResponse(collectEntity.getTile());
    }
}
