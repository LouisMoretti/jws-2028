package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.YakadexConverter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class YakadexTest {
    @Inject
    YakadexConverter yakadexConverter;

    @Test
    public void basicTest() {
        // TODO
    }

    @Test
    public void nullTest() {
        assertNull(yakadexConverter.entityToResponse(null));
    }
}
