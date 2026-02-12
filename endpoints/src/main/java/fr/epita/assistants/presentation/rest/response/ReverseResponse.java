package fr.epita.assistants.presentation.rest.response;

import lombok.Getter;

@Getter
public class ReverseResponse {
    String original;
    String reversed;

    public ReverseResponse(String original) {
        this.original = original;
        this.reversed = new StringBuilder(original).reverse().toString();
    }
}
