package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class YakamonTest {
    @Inject
    YakamonConverter yakamonConverter;

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
        assertNull(yakamonConverter.modelToEntity(null));
    }

    @Test
    public void null2Test() {
        assertNull(yakamonConverter.entityToResponse(null));
    }
}
