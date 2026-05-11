package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
