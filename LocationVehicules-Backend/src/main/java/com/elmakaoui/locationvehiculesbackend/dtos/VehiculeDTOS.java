package com.elmakaoui.locationvehiculesbackend.dtos;

import com.elmakaoui.locationvehiculesbackend.entities.Agence;
import com.elmakaoui.locationvehiculesbackend.entities.Location;
import com.elmakaoui.locationvehiculesbackend.enums.StatutVehicule;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VehiculeDTOS {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private Double prixParJour;
    private Date dateMiseEnService;
    private StatutVehicule statut;
    private Long agenceId;
}
