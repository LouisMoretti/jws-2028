package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.YakamonTeamConverter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class YakamonTeamTest {
    @Inject
    YakamonTeamConverter yakamonTeamConverter;

    @Test
    public void basicTest() {
        // TODO
    }

    @Test
    public void nullTest() {
        assertNull(yakamonTeamConverter.entityToResponse(null));
    }
}
