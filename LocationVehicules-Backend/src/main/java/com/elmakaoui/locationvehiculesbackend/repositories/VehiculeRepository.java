package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Vehicule;
import com.elmakaoui.locationvehiculesbackend.enums.StatutVehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByMarqueContainsIgnoreCase(String keyword);
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByAgenceId(Long agenceId);
}
