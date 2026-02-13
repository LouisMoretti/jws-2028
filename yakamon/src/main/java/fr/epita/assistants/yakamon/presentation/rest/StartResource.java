package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.StartConverter;
import fr.epita.assistants.yakamon.domain.entity.StartEntity;
import fr.epita.assistants.yakamon.domain.service.StartService;
import fr.epita.assistants.yakamon.presentation.api.request.StartRequest;
import fr.epita.assistants.yakamon.presentation.api.response.StartResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/start")
@Consumes(MediaType.APPLICATION_JSON)
public class StartResource {
    @Inject
    StartService startService;

    @Inject
    StartConverter startConverter;

    @POST
    public Response postStart(StartRequest request) {
        // Validate entries or return status 400

        // Call service to: Clear all the database tables. Initialize and start the game.
        StartEntity startEntity = startService.startLogic(request.getPlayerName(), request.getMapPath());

        return Response.ok(startConverter.entityToResponse(startEntity), MediaType.APPLICATION_JSON).build();
    }
}
