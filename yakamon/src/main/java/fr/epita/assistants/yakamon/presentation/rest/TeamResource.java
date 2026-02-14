package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.YakamonTeamConverter;
import fr.epita.assistants.yakamon.domain.entity.YakamonTeamEntity;
import fr.epita.assistants.yakamon.domain.service.ReleaseService;
import fr.epita.assistants.yakamon.domain.service.TeamService;
import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import fr.epita.assistants.yakamon.presentation.api.response.YakamonTeamResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang.NotImplementedException;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    TeamService teamService;

    @Inject
    YakamonTeamConverter yakamonTeamConverter;

    @Inject
    ReleaseService releaseService;

    @Path("/")
    @GET
    public Response getTeam() {
        YakamonTeamEntity yakamonTeam = teamService.getTeam();

        YakamonTeamResponse response = yakamonTeamConverter.entityToResponse(yakamonTeam);
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{uuid}/evolve")
    @POST
    public Response postEvolve(@PathParam("uuid") long uuid) {
        throw new NotImplementedException();
    }

    @Path("/{uuid}/feed")
    @POST
    public Response postFeed(@PathParam("uuid") long uuid, FeedRequest feedRequest) {
        throw new NotImplementedException();
    }

    @Path("/{uuid}/release")
    @DELETE
    public Response deleteRelease(@PathParam("uuid") long uuid) {
        releaseService.release(uuid);
        return Response.status(204, "Yakamon successfully released.").build();
    }

    @Path("/{uuid}/rename")
    @PATCH
    public Response patchRename(@PathParam("uuid") long uuid, RenameRequest renameRequest) {
        throw new NotImplementedException();
    }
}
