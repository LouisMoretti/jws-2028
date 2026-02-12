package fr.epita.assistants.presentation.rest.response;

import lombok.Getter;

@Getter
public class HelloResponse {
    public String content;

    public HelloResponse(String name) {
        this.content = "hello " + name;
    }
}
