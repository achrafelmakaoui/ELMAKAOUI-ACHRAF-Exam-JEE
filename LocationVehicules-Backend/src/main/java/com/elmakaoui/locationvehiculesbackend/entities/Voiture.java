package com.elmakaoui.locationvehiculesbackend.entities;

import com.elmakaoui.locationvehiculesbackend.enums.BoiteVitesse;
import com.elmakaoui.locationvehiculesbackend.enums.TypeCarburant;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("VOITURE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voiture extends Vehicule {
    private Integer nombrePortes;

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}
