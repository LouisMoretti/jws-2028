package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.domain.entity.PlayerEntity;
import fr.epita.assistants.yakamon.presentation.api.response.PlayerResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerConverter {
    public PlayerResponse entityToResponse(PlayerEntity player) {
        return new PlayerResponse(
                player.getUuid(),
                player.getName(),
                player.getPoxX(),
                player.getPoxY(),
                player.getLastMove(),
                player.getLastCollect(),
                player.getLastCatch(),
                player.getLastFeed()
        );
    }

    public PlayerEntity modelToEntity(PlayerModel player) {
        return new PlayerEntity(
                player.getUuid(),
                player.getName(),
                player.getPosX(),
                player.getPosY(),
                player.getLastMove(),
                player.getLastCollect(),
                player.getLastCatch(),
                player.getLastFeed()
        );
    }
}
