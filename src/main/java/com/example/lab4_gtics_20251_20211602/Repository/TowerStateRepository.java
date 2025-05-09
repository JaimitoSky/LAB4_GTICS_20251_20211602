package com.example.lab4_gtics_20251_20211602.Repository;

import com.example.lab4_gtics_20251_20211602.Entity.TowerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowerStateRepository extends JpaRepository<TowerState, Integer> {
}
