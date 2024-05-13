package com.example.demo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shift_user")
public class ShiftUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "tenant_id")
    private UUID tenantId;

    // Constructors
    public ShiftUser() {
    }

    public ShiftUser(Shift shift, User user, UUID tenantId) {
        this.shift = shift;
        this.user = user;
        this.tenantId = tenantId;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public UUID getShiftId() {
        if (shift != null) {
            return shift.getId();
        }
        return null;
    }

    public UUID getUserId() {
        if (user != null) {
            return user.getId();
        }
        return null;
    }
}
