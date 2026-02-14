package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexEntryResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class YakadexEntryConverter {
    public YakadexEntryEntity modelToEntity(YakadexEntryModel yakadexEntryModel) {
        if (yakadexEntryModel == null) return null;
        return new YakadexEntryEntity(
                yakadexEntryModel.getId(),
                yakadexEntryModel.getName(),
                yakadexEntryModel.getFirstType(),
                yakadexEntryModel.getSecondType(),
                yakadexEntryModel.getEvolveThreshold(),
                yakadexEntryModel.getEvolution() == null ?
                        null : yakadexEntryModel.getEvolution().getId(),
                yakadexEntryModel.getCaught(),
                yakadexEntryModel.getDescription()
        );
    }

    public YakadexEntryResponse entityToResponse(YakadexEntryEntity yakadexEntryEntity) {
        if (yakadexEntryEntity == null) return null;
        return new YakadexEntryResponse(
                yakadexEntryEntity.getId(),
                yakadexEntryEntity.getName(),
                yakadexEntryEntity.getFirstType(),
                yakadexEntryEntity.getSecondType(),
                yakadexEntryEntity.getEvolveThreshold(),
                yakadexEntryEntity.getEvolutionId(),
                yakadexEntryEntity.getCaught(),
                yakadexEntryEntity.getDescription()
        );
    }
}
