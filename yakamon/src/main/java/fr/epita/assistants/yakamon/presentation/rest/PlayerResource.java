package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.domain.service.MoveService;
import fr.epita.assistants.yakamon.presentation.api.request.MoveRequest;
import fr.epita.assistants.yakamon.presentation.api.response.MoveResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang.NotImplementedException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    MoveService moveService;

    @Path("/catch")
    @POST
    public Response postCatch() {
        throw new NotImplementedException();
    }

    @Path("/collect")
    @POST
    public Response postCollect() {
        throw new NotImplementedException();
    }

    @Path("/move")
    @POST
    public Response postMove(MoveRequest moveRequest) {
        MoveEntity move = moveService.movePlayer(moveRequest.getDirection());

        MoveResponse moveResponse = new MoveResponse(move.getPosition().getPosX(), move.getPosition().getPosY());
        return Response.ok(moveResponse, MediaType.APPLICATION_JSON).build();
    }

    @Path("/player")
    @GET
    public Response getPayer() {
        throw new NotImplementedException();
    }
}
