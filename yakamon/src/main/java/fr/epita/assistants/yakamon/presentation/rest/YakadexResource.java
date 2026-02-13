package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.YakadexEntryConverter;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntity;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.domain.service.YakadexService;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexEntryResponse;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/yakadex")
@Produces(MediaType.APPLICATION_JSON)
public class YakadexResource {
    @Inject
    YakadexService yakadexService;

    @Inject
    YakadexEntryConverter yakadexEntryConverter;

    @Path("/")
    @GET
    public Response getYakadex(@QueryParam("only_missing") boolean onlyMissing) {
        YakadexEntity yakadexEntity = yakadexService.getYakadex(onlyMissing);

        List<YakadexEntryResponse> entries = yakadexEntity
                .getEntries()
                .stream()
                .map(entry -> yakadexEntryConverter.entityToResponse(entry))
                .toList();

        YakadexResponse yakadex = new YakadexResponse(entries);
        return Response.ok(yakadex, MediaType.APPLICATION_JSON).build();
    }

    @Path("/{id}")
    @GET
    public Response getYakadexEntry(@PathParam("id") long id) {
        YakadexEntryEntity yakadexEntryEntity = yakadexService.getYakadexEntry(id);
        YakadexEntryResponse entry = yakadexEntryConverter.entityToResponse(yakadexEntryEntity);

        return Response.ok(entry, MediaType.APPLICATION_JSON).build();
    }
}
