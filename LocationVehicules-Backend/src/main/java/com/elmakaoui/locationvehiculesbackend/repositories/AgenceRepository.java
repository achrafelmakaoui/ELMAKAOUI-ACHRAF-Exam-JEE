package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
    List<Agence> findByNomContainsIgnoreCase(String keyword);
    List<Agence> findByVille(String ville);
}
