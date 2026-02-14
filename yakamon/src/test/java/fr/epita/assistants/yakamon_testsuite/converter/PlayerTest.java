package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.PlayerConverter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class PlayerTest {
    @Inject
    PlayerConverter playerConverter;

    @Test
    public void basicTest() {
        // TODO
    }

    @Test
    public void basic2Test() {
        // TODO
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
