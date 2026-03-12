package fr.epita.assistants.yakamon_testsuite.service;

import fr.epita.assistants.yakamon.domain.service.TeamService;
import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import fr.epita.assistants.yakamon.domain.service.GameService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class TeamTest {
    @Inject
    TeamService teamService;

    @Inject
    GameService gameService;

    @Test
    public void notStartedTest() {
        try {
            teamService.getTeam();
        } catch (Exception e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    public void basicTest() {
        gameService.startLogic("LeTigre", "src/main/resources/maps/walkable.epimap");

        YakamonTeamEntity team = teamService.getTeam();
        assertEquals(0, team.getYakamons().size());
    }

}
