package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class YakamonResponse {
    private UUID uuid;
    private String nickname;
    private Integer yakadexId;
    private Integer energyPoints;
}
