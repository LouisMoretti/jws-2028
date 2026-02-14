package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.YakadexEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class YakadexConverter {
    @Inject
    YakadexEntryConverter yakadexEntryConverter;

    public YakadexResponse entityToResponse(YakadexEntity yakadexEntity) {
        if (yakadexEntity == null) return null;
        return new YakadexResponse(yakadexEntity
                .getEntries()
                .stream()
                .map(entry -> yakadexEntryConverter.entityToResponse(entry))
                .toList()
        );
    }
}
