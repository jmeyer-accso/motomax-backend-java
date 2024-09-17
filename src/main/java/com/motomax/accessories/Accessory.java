package com.motomax.accessories;

import com.motomax.models.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accessories")
@NamedQuery(
        name = "Accessory.findByModelCode",
        query = "SELECT a FROM Accessory a LEFT JOIN a.supportedModels m WHERE m.modelCode=:modelCode"
)
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accessoryCode;
    private String name;
    @ManyToMany(mappedBy = "accessories")
    private Set<Model> supportedModels = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAccessoryCode() {
        return accessoryCode;
    }

    public void setAccessoryCode(String accessoryCode) {
        this.accessoryCode = accessoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Model> getSupportedModels() {
        return supportedModels;
    }

    public void setSupportedModels(Set<Model> supportedModels) {
        this.supportedModels = supportedModels;
    }
}
