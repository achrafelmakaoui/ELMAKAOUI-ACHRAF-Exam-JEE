package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
