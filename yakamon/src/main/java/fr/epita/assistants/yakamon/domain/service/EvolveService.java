package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.lang.NotImplementedException;

import java.util.UUID;

@ApplicationScoped
public class EvolveService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    public YakamonEntity evolve(String uuid) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        // 400 The yakamon needs more energy points to evolve.

        YakamonModel yakamon = yakamonRepository.getYakamonFromUUID(UUID.fromString(uuid));

        // 404 The yakamon reached its maximum evolution tier.

        throw new NotImplementedException();
    }
}
