package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
