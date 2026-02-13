package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.YakadexConverter;
import fr.epita.assistants.yakamon.converter.YakadexEntryConverter;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntity;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.domain.service.YakadexEntryService;
import fr.epita.assistants.yakamon.domain.service.YakadexService;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexEntryResponse;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/yakadex")
@Produces(MediaType.APPLICATION_JSON)
public class YakadexResource {
    @Inject
    YakadexService yakadexService;

    @Inject
    YakadexEntryService yakadexEntryService;

    @Inject
    YakadexEntryConverter yakadexEntryConverter;

    @Inject
    YakadexConverter yakadexConverter;

    @Path("/")
    @GET
    public Response getYakadex(@QueryParam("only_missing") boolean onlyMissing) {
        YakadexEntity yakadexEntity = yakadexService.getYakadex(onlyMissing);

        YakadexResponse yakadex = yakadexConverter.entityToResponse(yakadexEntity);
        return Response.ok(yakadex, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{id}")
    @GET
    public Response getYakadexEntry(@PathParam("id") long id) {
        YakadexEntryEntity yakadexEntryEntity = yakadexEntryService.getYakadexEntry(id);

        YakadexEntryResponse entry = yakadexEntryConverter.entityToResponse(yakadexEntryEntity);
        return Response.ok(entry, MediaType.APPLICATION_JSON).build();
    }
}
