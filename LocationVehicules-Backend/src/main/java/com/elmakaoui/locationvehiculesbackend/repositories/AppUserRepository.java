package com.elmakaoui.locationvehiculesbackend.repositories;

import com.elmakaoui.locationvehiculesbackend.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
