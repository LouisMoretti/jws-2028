package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakadexEntryRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.utils.ErrorCode;
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

    @Inject
    YakadexEntryRepository yakadexEntryRepository;

    @Inject
    YakamonConverter yakamonConverter;

    public YakamonEntity evolve(String uuid) {
        // Check if game is started.
        gameRepository.checkGameExistence();

        YakamonModel yakamon = yakamonRepository.getYakamonFromUUID(UUID.fromString(uuid));

        if (yakamon.yakadexEntry.evolution == null) {
            ErrorCode.NO_EVOLUTION_ERROR.throwException();
        }

        YakadexEntryModel entryModel = yakamon.getYakadexEntry();
        if (entryModel.getEvolveThreshold() > yakamon.getEnergyPoints()) {
            ErrorCode.NOT_ENOUGH_ENERGY_ERROR.throwException();
        }

        YakadexEntryModel evolution = entryModel.evolution;
        yakadexEntryRepository.setCaughtStateById(evolution.id);

        yakamon = yakamonRepository.evolve(
                yakamon.uuid,
                yakamon.nickname.compareTo(yakamon.yakadexEntry.name) == 0 ? evolution.name : yakamon.nickname,
                yakamon.energyPoints - entryModel.getEvolveThreshold(),
                evolution
                );

        return yakamonConverter.modelToEntity(yakamon);
    }
}
