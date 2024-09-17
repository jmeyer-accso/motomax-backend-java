package com.motomax.models;

import com.motomax.accessories.Accessory;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

@QuarkusTest
class ModelServiceTest {
    @Inject
    ModelService modelService;

    @Inject
    EntityManager entityManager;

    @Test
    @TestTransaction
    public void testGetModelByCode() {
        Model expectedModel = seedModelWithAccessories();

        Model actual = modelService.getModelByCode(expectedModel.getModelCode());
        assertThat(actual).isEqualTo(expectedModel);
    }

    private Model seedModelWithAccessories() {
        Model model = new Model();
        model.setModelCode("TMACC");
        for (int j = 0; j < 5; j++) {
            Accessory accessory = new Accessory();
            accessory.setAccessoryCode("AC" + j);
            accessory.setName("Accessory " + j);
            accessory.getSupportedModels().add(model);
            model.getAccessories().add(accessory);
        }
        entityManager.persist(model);
        model.getAccessories().forEach(accessory -> entityManager.persist(accessory));
        return model;
    }

    @Test
    @TestTransaction
    public void testListModels() {
        seedModelInventory();

        var models = modelService.listModels().stream().sorted(Comparator.comparing(ModelSummary::modelCode)).toList();
        assertThat(models)
                .hasSize(3)
                .extracting(ModelSummary::inventoryCount)
                .containsExactly(1L, 2L, 3L);
    }

    private void seedModelInventory() {
        for (int i = 0; i < 3; i++) {
            Model model = new Model();
            model.setModelCode("TM" + i);
            for (int j = 0; j < i + 1; j++) {
                InventoryItem item = new InventoryItem();
                item.setVinNumber("VIN" + i + j);
                item.setAvailable(true);
                item.setModel(model);
                model.getInventory().add(item);
            }
            entityManager.persist(model);
            model.getInventory().forEach(item -> entityManager.persist(item));
        }
    }

}
