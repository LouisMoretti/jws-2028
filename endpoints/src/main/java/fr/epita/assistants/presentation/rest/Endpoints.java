package fr.epita.assistants.presentation.rest;

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
    public Response getHello(@PathParam("name") HelloResponse response) {
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

    @Path("/reverse/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response postReverse(ReverseRequest request) {
        if (request == null || request.getContent() == null || request.getContent().isEmpty())
            return Response.status(400).build();

        return Response.ok(new ReverseResponse(request), MediaType.APPLICATION_JSON).build();
    }
}
