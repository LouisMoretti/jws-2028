package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.GameModel;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GameRepository implements PanacheRepository<GameModel> {
    public void checkGameExistence() {
        long nbInstances = count();
        if (nbInstances == 0) {
            ErrorCode.NO_GAME_ERROR.throwException();
        } else if (nbInstances > 1) {
            ErrorCode.TOO_MANY_GAMES_ERROR.throwException();
        }
    }

    @Transactional
    public void createGame(GameModel game) {
        persist(game);
    }

    public String getMap() {
        return listAll().getFirst().getMap();
    }

    @Transactional
    public void updateMap(String map) {
        update("map", map);
    }
}
