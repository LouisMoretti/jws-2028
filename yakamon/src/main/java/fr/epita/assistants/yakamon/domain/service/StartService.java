package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.GameModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakadexEntryRepository;
import fr.epita.assistants.yakamon.domain.entity.StartEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StartService {
    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    GameRepository gameRepository;

    public StartEntity startLogic(String playerName, String mapPath) {
        // Create the game in the game table
        GameModel game = new GameModel();
        game.setMap(mapPath);
        gameRepository.createGame(game);

        // Reset caught state in yakadex
        yakadexEntryRepository.resetCaughtState();

        // Create the player in the player table

        // Add 5 yakaballs to the item table

        return new StartEntity(null);
    }
}
