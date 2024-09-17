package com.motomax.models;

import com.motomax.accessories.Accessory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "models")
@NamedQuery(
        name = "Models.findByModelCode",
        query = "SELECT m FROM Model m LEFT JOIN FETCH m.accessories WHERE m.modelCode=:modelCode"
)
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelCode;

    @OneToMany
    @JoinColumn(name = "model_id")
    private List<InventoryItem> inventory = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "model_accessories",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "accessory_id")
    )
    private Set<Accessory> accessories = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }
}
