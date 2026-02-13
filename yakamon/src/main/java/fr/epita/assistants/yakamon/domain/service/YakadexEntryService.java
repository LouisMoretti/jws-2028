package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakadexEntryConverter;
import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakadexEntryRepository;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class YakadexEntryService {
    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    YakadexEntryConverter yakadexEntryConverter;

    @Inject
    GameRepository gameRepository;

    public YakadexEntryEntity getYakadexEntry(long id) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        YakadexEntryModel entryModel = yakadexEntryRepository.getEntryById(id);
        if (entryModel == null)
            ErrorCode.YAKAMON_NON_EXISTENT_ERROR.throwException();

        YakadexEntryEntity entry = yakadexEntryConverter.modelToEntity(entryModel);
        if (entry.getCaught() == false) {
            entry.setFirstType(null);
            entry.setSecondType(null);
            entry.setEvolveThreshold(null);
            entry.setEvolutionId(null);
            entry.setDescription(null);
        }

        return entry;
    }
}
