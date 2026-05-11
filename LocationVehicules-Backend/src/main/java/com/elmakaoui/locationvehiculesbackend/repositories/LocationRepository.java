package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Location;
import com.elmakaoui.locationvehiculesbackend.enums.StatutLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByVehiculeId(Long vehiculeId);
    List<Location> findByStatut(StatutLocation statut);
    List<Location> findByEmailClient(String email);
}
