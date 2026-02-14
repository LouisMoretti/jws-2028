package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.FeedConverter;
import fr.epita.assistants.yakamon.converter.RenameConverter;
import fr.epita.assistants.yakamon.converter.YakamonConverter;
import fr.epita.assistants.yakamon.converter.YakamonTeamConverter;
import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonEntity;
import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import fr.epita.assistants.yakamon.domain.service.*;
import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonResponse;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonTeamResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    TeamService teamService;

    @Inject
    YakamonTeamConverter yakamonTeamConverter;

    @Inject
    ReleaseService releaseService;

    @Inject
    FeedService feedService;

    @Inject
    EvolveService evolveService;

    @Inject
    RenameService renameService;

    @Inject
    YakamonConverter yakamonConverter;

    @Inject
    FeedConverter feedConverter;

    @Inject
    RenameConverter renameConverter;

    @Path("/")
    @GET
    public Response getTeam() {
        YakamonTeamEntity yakamonTeam = teamService.getTeam();

        YakamonTeamResponse response = yakamonTeamConverter.entityToResponse(yakamonTeam);
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{uuid}/evolve")
    @POST
    public Response postEvolve(@PathParam("uuid") String uuid) {
        YakamonEntity yakamon = evolveService.evolve(uuid);

        YakamonResponse response = yakamonConverter.entityToResponse(yakamon);
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{uuid}/feed")
    @POST
    public Response postFeed(@PathParam("uuid") String uuid, FeedRequest feedRequest) {
        FeedEntity feedEntity = feedConverter.requestToEntity(uuid, feedRequest);
        YakamonEntity yakamon = feedService.feed(feedEntity);

        YakamonResponse response = yakamonConverter.entityToResponse(yakamon);
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{uuid}/release")
    @DELETE
    public Response deleteRelease(@PathParam("uuid") String uuid) {
        releaseService.release(uuid);
        return Response.status(204, "Yakamon successfully released.").build();
    }

    @Path("/{uuid}/rename")
    @PATCH
    public Response patchRename(@PathParam("uuid") String uuid, RenameRequest renameRequest) {
        RenameEntity renameEntity = renameConverter.requestToEntity(uuid, renameRequest);
        YakamonEntity yakamon = renameService.rename(renameEntity);

        YakamonResponse response = yakamonConverter.entityToResponse(yakamon);
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }
}
