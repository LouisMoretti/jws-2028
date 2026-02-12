package fr.epita.assistants.presentation.rest.request;

import lombok.Getter;

@Getter
public class ReverseRequest {
    String original;
    String reversed;

    public ReverseRequest(String original) {
        this.original = original;
        this.reversed = new StringBuilder(original).reverse().toString();
    }
}
