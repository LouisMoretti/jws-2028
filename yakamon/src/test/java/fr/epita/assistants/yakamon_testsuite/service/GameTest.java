package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GameTest {
    @Inject
    GameService gameService;

    @Test
    public void basicTest() {
        // TODO
    }
}
