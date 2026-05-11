package com.elmakaoui.locationvehiculesbackend.dtos;

import com.elmakaoui.locationvehiculesbackend.enums.BoiteVitesse;
import com.elmakaoui.locationvehiculesbackend.enums.TypeCarburant;
import lombok.Data;

@Data
public class VoitureDTOS extends VehiculeDTOS {
    private Integer nombrePortes;
    private TypeCarburant typeCarburant;
    private BoiteVitesse boiteVitesse;
}
