package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class YakamonConverter {
    public YakamonEntity modelToEntity(YakamonModel yakamon) {
        return new YakamonEntity(yakamon.getUuid(), yakamon.getNickname(), yakamon.getYakadexEntry().getId(),
                yakamon.getEnergyPoints());
    }

    public YakamonResponse entityToResponse(YakamonEntity yakamon) {
        return new YakamonResponse(yakamon.getUuid(), yakamon.getNickname(), yakamon.getYakadexId(),
                yakamon.getEnergyPoints());
    }
}
