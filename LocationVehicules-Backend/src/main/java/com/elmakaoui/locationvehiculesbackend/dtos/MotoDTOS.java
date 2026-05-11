package com.elmakaoui.locationvehiculesbackend.dtos;

import com.elmakaoui.locationvehiculesbackend.entities.Vehicule;
import com.elmakaoui.locationvehiculesbackend.enums.TypeMoto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class MotoDTOS extends VehiculeDTOS {
    private Integer cylindree;
    private TypeMoto typeMoto;
    private Boolean casqueInclus;
}
