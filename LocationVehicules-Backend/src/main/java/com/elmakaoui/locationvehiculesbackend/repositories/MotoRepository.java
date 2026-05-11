package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
