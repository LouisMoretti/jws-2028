package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.utils.Point;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<PlayerModel> {
    @Transactional
    public void addPlayer(PlayerModel player) {
        persist(player);
    }

    public PlayerModel getPlayer() {
        return listAll().getFirst();
    }

    @Transactional
    public void movePlayer(Point newPos) {
        PlayerModel player = getPlayer();

        player.setPosX(newPos.getPosX());
        player.setPosY(newPos.getPosY());
    }

    @Transactional
    public void updateLastMove(LocalDateTime now) {
        PlayerModel player = getPlayer();
        player.setLastMove(now);
    }

    @Transactional
    public void updateLastCollect(LocalDateTime now) {
        PlayerModel player = getPlayer();
        player.setLastCollect(now);
    }

    @Transactional
    public void updateLastCatch(LocalDateTime now) {
        PlayerModel player = getPlayer();
        player.setLastCatch(now);
    }

    @Transactional
    public void updateLastFeed(LocalDateTime now) {
        PlayerModel player = getPlayer();
        player.setLastFeed(now);
    }
}
