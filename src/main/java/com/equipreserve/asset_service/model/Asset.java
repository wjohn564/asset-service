package com.equipreserve.asset_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
// set the table name and creates DB indexes
@Table(name = "assets", indexes = {
        @Index(name = "idx_name", columnList = "name"),
        @Index(name = "idx_model", columnList = "model"),
        @Index(name = "idx_serial", columnList = "serial", unique = true)
})
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Primary key
    private Long id;

    @NotBlank
    @Column(nullable = false)
    // Scanner A/B/C
    private String name;
    @NotBlank
    @Column(nullable = false)
    // Model
    private String model;
    @NotBlank
    @Column(nullable = false, unique = true)
    // Serial number
    private String serial;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
