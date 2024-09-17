package com.motomax.models;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/models")
public class ModelResource {
    @Inject
    ModelService modelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelSummary> list() {
        return modelService.listModels();
    }
}
