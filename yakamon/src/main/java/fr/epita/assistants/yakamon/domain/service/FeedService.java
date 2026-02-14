package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.lang.NotImplementedException;

import java.util.UUID;

@ApplicationScoped
public class FeedService {
    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    public YakamonEntity feed(String uuid, FeedRequest feedRequest) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        YakamonModel yakamon = yakamonRepository.getYakamonFromUUID(UUID.fromString(uuid));

        throw new NotImplementedException();
    }
}
