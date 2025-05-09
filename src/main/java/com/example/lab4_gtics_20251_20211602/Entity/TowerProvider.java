package com.example.lab4_gtics_20251_20211602.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tower_provider")
public class TowerProvider {
    @EmbeddedId
    private TowerProviderId id;

    @ManyToOne
    @MapsId("towerId")
    @JoinColumn(name = "tower_id")
    private Tower tower;

    @ManyToOne
    @MapsId("providerId")
    @JoinColumn(name = "provider_id")
    private Provider provider;
}
