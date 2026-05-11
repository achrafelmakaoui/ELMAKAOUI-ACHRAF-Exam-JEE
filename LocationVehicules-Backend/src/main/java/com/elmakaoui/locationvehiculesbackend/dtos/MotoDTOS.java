package com.elmakaoui.locationvehiculesbackend.dtos;

import com.elmakaoui.locationvehiculesbackend.entities.Vehicule;
import com.elmakaoui.locationvehiculesbackend.enums.TypeMoto;
import lombok.Data;

@Data
public class MotoDTOS extends Vehicule {
    private Integer cylindree;
    private TypeMoto typeMoto;
    private Boolean casqueInclus;
}
