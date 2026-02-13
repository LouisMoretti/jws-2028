package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.epita.assistants.yakamon.utils.ElementType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class YakadexEntryResponse {
    private Integer id;
    private String name;
    private ElementType firstType;
    private ElementType secondType;
    private Integer evolveThreshold;
    private Integer evolutionId;
    private Boolean caught;
    private String description;
}
