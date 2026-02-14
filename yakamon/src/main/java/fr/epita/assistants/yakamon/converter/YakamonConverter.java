package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.domain.entity.CatchEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class YakamonConverter {
    public CatchEntity modelToEntity(YakamonModel yakamon) {
        return new CatchEntity(yakamon.getUuid(), yakamon.getNickname(), yakamon.getYakadexEntry().getId(),
                yakamon.getEnergyPoints());
    }

    public YakamonResponse entityToResponse(CatchEntity yakamon) {
        return new YakamonResponse(yakamon.getUuid(), yakamon.getNickname(), yakamon.getYakadexId(),
                yakamon.getEnergyPoints());
    }
}
