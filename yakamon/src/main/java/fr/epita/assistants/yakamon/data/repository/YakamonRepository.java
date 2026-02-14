package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.stream.Stream;

@ApplicationScoped
public class YakamonRepository implements PanacheRepository<YakamonModel> {
    public long yakamonCount() {
        return count();
    }

    @Transactional
    public void addYakamon(YakamonModel yakamon) {
        persist(yakamon);
    }

    public Stream<YakamonModel> getYakamons() {
        return findAll().stream();
    }
}
