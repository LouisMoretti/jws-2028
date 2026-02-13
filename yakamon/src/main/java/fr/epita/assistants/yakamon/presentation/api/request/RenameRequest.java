package fr.epita.assistants.yakamon.presentation.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RenameRequest {
    private String newNickname;
}
