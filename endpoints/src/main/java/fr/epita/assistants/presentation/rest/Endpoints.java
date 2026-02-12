package fr.epita.assistants.presentation.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.epita.assistants.presentation.rest.request.ReverseRequest;
import fr.epita.assistants.presentation.rest.response.HelloResponse;
import fr.epita.assistants.presentation.rest.response.ReverseResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public Response reverse(String body) throws JsonProcessingException {
        if (body.isEmpty())
            return Response.status(400).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.readTree(body).get("content").asText();

        ReverseRequest request = new ReverseRequest(content);

        ReverseResponse response = new ReverseResponse(request);

        String json = objectMapper.writer().writeValueAsString(response);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
