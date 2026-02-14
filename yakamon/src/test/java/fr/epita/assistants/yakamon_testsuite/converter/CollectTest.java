package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.CollectConverter;
import fr.epita.assistants.yakamon.domain.entity.CollectEntity;
import fr.epita.assistants.yakamon.presentation.api.response.CollectResponse;
import fr.epita.assistants.yakamon.utils.tile.ItemType;
import fr.epita.assistants.yakamon.utils.tile.TerrainType;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class CollectTest {
    @Inject
    CollectConverter collectConverter;

    @Test
    public void basicTest() {
        TileType tile = new TileType(TerrainType.GRASS, ItemType.NONE);
        CollectEntity entity = new CollectEntity(tile);

        CollectResponse response = collectConverter.entityToResponse(entity);
        assertEquals(response.getTileType(), tile);
    }

    @Test
    public void nullTest() {
        CollectResponse response = collectConverter.entityToResponse(null);
        assertNull(response);
    }
}
