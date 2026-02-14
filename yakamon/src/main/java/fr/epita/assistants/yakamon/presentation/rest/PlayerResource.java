package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.CollectConverter;
import fr.epita.assistants.yakamon.converter.MoveConverter;
import fr.epita.assistants.yakamon.converter.PlayerConverter;
import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.domain.entity.CatchEntity;
import fr.epita.assistants.yakamon.domain.entity.CollectEntity;
import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.domain.entity.PlayerEntity;
import fr.epita.assistants.yakamon.domain.service.CatchService;
import fr.epita.assistants.yakamon.domain.service.CollectService;
import fr.epita.assistants.yakamon.domain.service.MoveService;
import fr.epita.assistants.yakamon.domain.service.PlayerService;
import fr.epita.assistants.yakamon.presentation.api.request.MoveRequest;
import fr.epita.assistants.yakamon.presentation.api.response.CollectResponse;
import fr.epita.assistants.yakamon.presentation.api.response.MoveResponse;
import fr.epita.assistants.yakamon.presentation.api.response.PlayerResponse;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    MoveService moveService;

    @Inject
    CatchService catchService;

    @Inject
    PlayerService playerService;

    @Inject
    CollectService collectService;

    @Inject
    YakamonConverter yakamonConverter;

    @Inject
    PlayerConverter playerConverter;

    @Inject
    MoveConverter moveConverter;

    @Inject
    CollectConverter collectConverter;

    @Path("/catch")
    @POST
    public Response postCatch() {
        CatchEntity catchEntity = catchService.catchYakamon();

        YakamonResponse yakamonResponse = yakamonConverter.entityToResponse(catchEntity);
        return Response.ok(yakamonResponse, MediaType.APPLICATION_JSON).build();
    }

    @Path("/collect")
    @POST
    public Response postCollect() {
        CollectEntity collectEntity = collectService.collect();

        CollectResponse collectResponse = collectConverter.entityToResponse(collectEntity);
        return Response.ok(collectResponse, MediaType.APPLICATION_JSON).build();
    }

    @Path("/move")
    @POST
    public Response postMove(MoveRequest moveRequest) {
        MoveEntity move = moveService.movePlayer(moveRequest.getDirection());

        MoveResponse moveResponse = moveConverter.entityToResponse(move);
        return Response.ok(moveResponse, MediaType.APPLICATION_JSON).build();
    }

    @Path("/player")
    @GET
    public Response getPayer() {
        PlayerEntity player = playerService.getPlayer();

        PlayerResponse playerResponse = playerConverter.entityToResponse(player);
        return Response.ok(playerResponse, MediaType.APPLICATION_JSON).build();
    }
}
