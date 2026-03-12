package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.PlayerConverter;
import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.domain.entity.PlayerEntity;
import fr.epita.assistants.yakamon.presentation.api.response.PlayerResponse;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;

@QuarkusTest
public class PlayerTest {
    @Inject
    PlayerConverter playerConverter;

    @Test
    public void basicTest() {
        PlayerEntity playerEntity = new PlayerEntity(UUID.randomUUID(), "TIGER", 0, 0, null, null, null, null);

        PlayerResponse playerResponse = playerConverter.entityToResponse(playerEntity);
        assertEquals(playerEntity.getUuid(), playerResponse.getUuid());
        assertEquals(playerEntity.getName(), playerResponse.getName());
        assertEquals(playerEntity.getPoxX(), playerResponse.getPosX());
        assertEquals(playerEntity.getPoxY(), playerResponse.getPosY());
        assertEquals(playerEntity.getLastMove(), playerResponse.getLastMove());
        assertEquals(playerEntity.getLastCollect(), playerResponse.getLastCollect());
        assertEquals(playerEntity.getLastCatch(), playerResponse.getLastCatch());
        assertEquals(playerEntity.getLastFeed(), playerResponse.getLastFeed());
    }

    @Test
    public void basic2Test() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setUuid(UUID.randomUUID());
        playerModel.setName("TIGER");
        playerModel.setPosX(0);
        playerModel.setPosY(0);

        PlayerEntity playerEntity = playerConverter.modelToEntity(playerModel);
        assertEquals(playerModel.getUuid(), playerEntity.getUuid());
        assertEquals(playerModel.getName(), playerEntity.getName());
        assertEquals(playerModel.getPosX(), playerEntity.getPoxX());
        assertEquals(playerModel.getPosY(), playerEntity.getPoxY());
        assertEquals(playerModel.getLastMove(), playerEntity.getLastMove());
        assertEquals(playerModel.getLastCollect(), playerEntity.getLastCollect());
        assertEquals(playerModel.getLastCatch(), playerEntity.getLastCatch());
        assertEquals(playerModel.getLastFeed(), playerEntity.getLastFeed());
    }

    @Test
    public void nullTest() {
        assertNull(playerConverter.entityToResponse(null));
    }

    @Test
    public void null2Test() {
        assertNull(playerConverter.modelToEntity(null));
    }
}
