package fr.epita.assistants.presentation.rest.response;

import fr.epita.assistants.presentation.rest.request.ReverseRequest;
import lombok.Getter;

@Getter
public class ReverseResponse {
    String original;
    String reversed;

    public ReverseResponse(ReverseRequest request) {
        this.original = request.getOriginal();
        this.reversed = request.getReversed();
    }
}
