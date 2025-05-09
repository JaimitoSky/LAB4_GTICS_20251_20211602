package com.example.lab4_gtics_20251_20211602.Repository;
import com.example.lab4_gtics_20251_20211602.Entity.Provider;
import com.example.lab4_gtics_20251_20211602.Entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}

