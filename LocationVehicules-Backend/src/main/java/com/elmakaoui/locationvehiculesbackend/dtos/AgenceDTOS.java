package com.elmakaoui.locationvehiculesbackend.dtos;

import lombok.Data;

@Data
public class AgenceDTOS {
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private String telephone;

}
