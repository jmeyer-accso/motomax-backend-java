package com.motomax.models;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ModelService {
    @Inject
    EntityManager entityManager;

    public List<ModelSummary> listModels() {
        return entityManager
                .createQuery(
                        "SELECT new com.motomax.models.ModelSummary(m.modelCode, count(i.id)) " +
                                "FROM Model m LEFT JOIN m.inventory i " +
                                "GROUP BY m.modelCode",
                        ModelSummary.class)
                .getResultList();
    }

    public Model getModelByCode(String modelCode) {
        return entityManager.createNamedQuery("Models.findByModelCode", Model.class)
                .setParameter("modelCode", modelCode)
                .getSingleResult();
    }

}
