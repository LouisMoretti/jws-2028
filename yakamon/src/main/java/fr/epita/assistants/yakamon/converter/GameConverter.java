package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.StartEntity;
import fr.epita.assistants.yakamon.presentation.api.response.StartResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameConverter {
    public StartResponse entityToResponse(StartEntity startEntity) {
        return new StartResponse(startEntity.getMap());
    }
}
