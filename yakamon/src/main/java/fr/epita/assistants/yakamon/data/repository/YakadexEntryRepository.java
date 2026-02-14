package fr.epita.assistants.yakamon.data.repository;

import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.stream.Stream;

@ApplicationScoped
public class YakadexEntryRepository implements PanacheRepository<YakadexEntryModel> {
    @Transactional
    public void resetCaughtState() {
        update("caught", false);
    }

    public Stream<YakadexEntryModel> allEntriesFiltered(boolean onlyMissing) {
        if (onlyMissing) {
            return find("caught", false).stream();
        }
        return findAll().stream();
    }

    public YakadexEntryModel getEntryById(long id) {
        return findById(id);
    }

    @Transactional
    public void setCaughtStateById(long id) {
        findById(id).setCaught(true);
    }
}
