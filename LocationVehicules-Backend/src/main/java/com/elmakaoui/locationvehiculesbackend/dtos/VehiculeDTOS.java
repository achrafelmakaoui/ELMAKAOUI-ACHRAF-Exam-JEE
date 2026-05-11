package com.elmakaoui.locationvehiculesbackend.dtos;

import com.elmakaoui.locationvehiculesbackend.enums.StatutVehicule;
import lombok.Data;

import java.util.Date;

@Data
public abstract class VehiculeDTOS {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private Double prixParJour;
    private Date dateMiseEnService;
    private StatutVehicule statut;
    private Long agenceId;
}
