package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.InventoryConverter;
import fr.epita.assistants.yakamon.domain.entity.InventoryEntity;
import fr.epita.assistants.yakamon.domain.service.InventoryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventory")
public class InventoryResource {
    @Inject
    InventoryService inventoryService;

    @Inject
    InventoryConverter inventoryConverter;

    @GET
    public Response getInventory() {
        InventoryEntity inventoryEntity = inventoryService.getInventory();
        return Response.ok(inventoryConverter.entityToResponse(inventoryEntity), MediaType.APPLICATION_JSON).build();
    }
}
