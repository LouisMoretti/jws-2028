package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class YakamonRepository implements PanacheRepository<YakamonModel> {
    public long yakamonCount() {
        return count();
    }

    @Transactional
    public void addYakamon(YakamonModel yakamon) {
        persist(yakamon);
    }

    public YakamonModel getYakamonById(long id) {
        return findAll().stream().filter(yakamonModel -> yakamonModel.getYakadexEntry().getId() == id).findFirst().get();
    }
}
