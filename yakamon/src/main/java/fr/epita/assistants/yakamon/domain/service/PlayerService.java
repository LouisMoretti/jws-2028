package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.PlayerConverter;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.PlayerRepository;
import fr.epita.assistants.yakamon.domain.entity.PlayerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PlayerService {
    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    PlayerConverter playerConverter;

    public PlayerEntity getPlayer() {
        // Check if game is started.
        gameRepository.checkGameExistence();

        return playerConverter.modelToEntity(playerRepository.getPlayer());
    }
}
