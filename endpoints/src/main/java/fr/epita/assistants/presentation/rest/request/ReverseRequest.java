package fr.epita.assistants.presentation.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReverseRequest {
    private String content;
//    String original;
//    String reversed;
//
//    public ReverseRequest(String original) {
//        this.original = original;
//        this.reversed = new StringBuilder(original).reverse().toString();
//    }
}
