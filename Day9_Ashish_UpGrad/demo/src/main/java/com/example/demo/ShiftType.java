package com.example.demo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shift_types")
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "uq_name")
    private String uqName;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "tenant_id")
    private UUID tenantId;

    // Constructors
    public ShiftType() {
    }

    public ShiftType(String uqName, String description, boolean active, String timeZone, UUID tenantId) {
        this.uqName = uqName;
        this.description = description;
        this.active = active;
        this.timeZone = timeZone;
        this.tenantId = tenantId;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUqName() {
        return uqName;
    }

    public void setUqName(String uqName) {
        this.uqName = uqName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }
}
