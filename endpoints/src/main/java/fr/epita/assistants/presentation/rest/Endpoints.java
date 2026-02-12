package fr.epita.assistants.presentation.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.epita.assistants.presentation.rest.response.HelloResponse;
import fr.epita.assistants.presentation.rest.response.ReverseResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class Endpoints {
    @Path("/hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String hello(@PathParam("name") String name) throws JsonProcessingException {
        HelloResponse response = new HelloResponse(name);

        ObjectWriter objectWriter = new ObjectMapper().writer();
        return objectWriter.writeValueAsString(response);
    }

    @Path("/reverse/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public String reverse(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.readTree(body).get("content").asText();

        ReverseResponse response = new ReverseResponse(content);
        return objectMapper.writer().writeValueAsString(response);
    }
}
