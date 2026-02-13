package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.MapConverter;
import fr.epita.assistants.yakamon.data.model.GameModel;
import fr.epita.assistants.yakamon.data.repository.*;
import fr.epita.assistants.yakamon.domain.entity.StartEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@ApplicationScoped
public class StartService {
    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    YakamonRepository yakamonRepository;

    @Inject
    MapConverter mapConverter;

    @Transactional
    public StartEntity startLogic(String playerName, String mapPath) {
        Path path = Paths.get(mapPath);
        if (!Files.exists(path))
            ErrorCode.START_ERROR.throwException();

        // Get the map
        String mapFileString = null;
        try {
            mapFileString = Files.readString(path);
        } catch (IOException e) {
            ErrorCode.START_ERROR.throwException(e.getMessage());
        }

        String map = mapConverter.fileStringToString(mapFileString);
        List<List<TileType>> tiles = mapConverter.stringToMatrix(map);

        itemRepository.deleteAll();
        playerRepository.deleteAll();
        gameRepository.deleteAll();
        yakamonRepository.deleteAll();

        // Create the game in the game table
        GameModel game = new GameModel();
        game.setMap(map);
        gameRepository.createGame(game);

        // Reset caught state in yakadex
        yakadexEntryRepository.resetCaughtState();

        // Create the player in the player table

        // Add 5 yakaballs to the item table

        return new StartEntity(tiles);
    }
}
