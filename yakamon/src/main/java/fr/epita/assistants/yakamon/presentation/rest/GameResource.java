package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.GameConverter;
import fr.epita.assistants.yakamon.domain.entity.GameEntity;
import fr.epita.assistants.yakamon.domain.service.GameService;
import fr.epita.assistants.yakamon.presentation.api.request.StartRequest;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/start")
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    @Inject
    GameService gameService;

    @Inject
    GameConverter gameConverter;

    @POST
    public Response postStart(StartRequest request) {
        // Validate entries or return status 400
        if (request.getPlayerName() == null
                || request.getPlayerName().isEmpty()
                || request.getMapPath() == null
                || request.getMapPath().isEmpty())
            ErrorCode.START_ERROR.throwException();

        // Call service to: Clear all the database tables. Initialize and start the game.
        GameEntity gameEntity = gameService.startLogic(request.getPlayerName(), request.getMapPath());

        return Response.ok(gameConverter.entityToResponse(gameEntity), MediaType.APPLICATION_JSON).build();
    }
}
