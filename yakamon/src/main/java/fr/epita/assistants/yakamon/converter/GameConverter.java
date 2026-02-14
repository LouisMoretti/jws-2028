package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.GameEntity;
import fr.epita.assistants.yakamon.presentation.api.response.StartResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameConverter {
    public StartResponse entityToResponse(GameEntity gameEntity) {
        return new StartResponse(gameEntity.getMap());
    }
}
