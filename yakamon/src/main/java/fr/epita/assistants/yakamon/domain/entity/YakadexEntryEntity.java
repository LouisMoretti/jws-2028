package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.utils.ElementType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class YakadexEntryEntity {
    private Integer id;
    private String name;
    private ElementType firstType;
    private ElementType secondType;
    private Integer evolveThreshold;
    private Integer evolutionId;
    private Boolean caught;
    private String description;
}
