package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.GameConverter;
import fr.epita.assistants.yakamon.domain.entity.GameEntity;
import fr.epita.assistants.yakamon.presentation.api.response.StartResponse;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class GameTest {
    @Inject
    GameConverter gameConverter;

    @Test
    public void basicTest() {
        List<List<TileType>> tiles = new ArrayList<>();
        GameEntity entity = new GameEntity(tiles);

        StartResponse response = gameConverter.entityToResponse(entity);
        assertEquals(response.getTiles(), tiles);
    }

    @Test
    public void nullTest() {
        assertNull(gameConverter.entityToResponse(null));
    }
}
