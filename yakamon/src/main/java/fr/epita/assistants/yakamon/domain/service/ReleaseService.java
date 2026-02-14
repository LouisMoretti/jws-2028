package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.repository.GameRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.lang.NotImplementedException;

@ApplicationScoped
public class ReleaseService {
    @Inject
    GameRepository gameRepository;

    public void release(long uuid) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        throw new NotImplementedException();
    }
}
