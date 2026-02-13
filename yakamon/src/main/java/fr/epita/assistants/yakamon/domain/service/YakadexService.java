package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakadexEntryConverter;
import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakadexEntryRepository;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntity;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class YakadexService {
    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    YakadexEntryConverter yakadexEntryConverter;

    @Inject
    GameRepository gameRepository;

    public YakadexEntity getYakadex(boolean onlyMissing) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        Stream<YakadexEntryModel> yakadexEntryModels = yakadexEntryRepository.allEntriesFiltered(onlyMissing);
        List<YakadexEntryEntity> yakadexEntryEntities = yakadexEntryModels
                .map(model -> yakadexEntryConverter.modelToEntity(model))
                .toList();

        return new YakadexEntity(yakadexEntryEntities);
    }

    public YakadexEntryEntity getYakadexEntry(long id) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        YakadexEntryModel entryModel = yakadexEntryRepository.getEntryById(id);
        if (entryModel == null)
            ErrorCode.YAKAMON_NON_EXISTENT.throwException();

        return yakadexEntryConverter.modelToEntity(entryModel);
    }
}
