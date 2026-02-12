package fr.epita.assistants.presentation.rest.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HelloResponse {
    public String content;

    public String getContent() {
        return "hello " + content;
    }
}
