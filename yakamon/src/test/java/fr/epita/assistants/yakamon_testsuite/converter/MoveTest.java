package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.MoveConverter;
import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.presentation.api.response.MoveResponse;
import fr.epita.assistants.yakamon.utils.Point;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class MoveTest {
    @Inject
    MoveConverter moveConverter;

    @Test
    public void basicTest() {
        MoveEntity entity = new MoveEntity(new Point(42, 42));

        MoveResponse response = moveConverter.entityToResponse(entity);
        assertEquals(entity.getPosition().getPosX(), response.getPosX());
        assertEquals(entity.getPosition().getPosY(), response.getPosY());
    }

    @Test
    public void nullTest() {
        assertNull(moveConverter.entityToResponse(null));
    }

    @Test
    public void null2Test() {
        assertNull(moveConverter.entityToResponse(new MoveEntity(null)));
    }
}
