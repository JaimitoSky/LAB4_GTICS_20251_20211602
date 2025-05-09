package com.example.lab4_gtics_20251_20211602.Entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter
public class TowerProviderId implements Serializable {

    private Integer towerId;
    private Integer providerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TowerProviderId)) return false;
        TowerProviderId that = (TowerProviderId) o;
        return Objects.equals(towerId, that.towerId) && Objects.equals(providerId, that.providerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(towerId, providerId);
    }
}
