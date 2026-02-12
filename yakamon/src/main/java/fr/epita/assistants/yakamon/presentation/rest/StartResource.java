package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.presentation.api.request.StartRequest;
import fr.epita.assistants.yakamon.presentation.api.response.StartResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/start")
@Consumes(MediaType.APPLICATION_JSON)
public class StartResource {
    @POST
    public Response postStart(StartRequest request) {
        // Validate entries or return status 400

        // Call service to: Clear all the database tables. Initialize and start the game.

        return Response.ok(new StartResponse(), MediaType.APPLICATION_JSON).build();
    }
}
