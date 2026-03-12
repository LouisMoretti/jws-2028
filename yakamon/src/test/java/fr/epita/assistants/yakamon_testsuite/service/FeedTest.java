package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.domain.entity.GameEntity;
import fr.epita.assistants.yakamon.domain.service.FeedService;
import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class FeedTest {
    @Inject
    FeedService feedService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        FeedEntity entity = new FeedEntity(UUID.randomUUID(), 1);

        try {
            feedService.feed(entity);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        FeedEntity entity = new FeedEntity(UUID.randomUUID(), 1);

        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        try {
            feedService.feed(entity);
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }
}
