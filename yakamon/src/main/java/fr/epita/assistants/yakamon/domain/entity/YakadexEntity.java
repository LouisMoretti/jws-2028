package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class YakadexEntity {
    private List<YakadexEntryEntity> entries;
}
