package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang.NotImplementedException;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Path("/")
    @GET
    public Response getTeam() {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

    @Path("/{uuid}/rename")
    @PATCH
    public Response patchRename(@PathParam("uuid") long uuid, RenameRequest renameRequest) {
        throw new NotImplementedException();
    }
}
