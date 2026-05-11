package com.elmakaoui.locationvehiculesbackend.entities;

import com.elmakaoui.locationvehiculesbackend.enums.StatutLocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Double montantTotal;

    @Enumerated(EnumType.STRING)
    private StatutLocation statut;

    private String nomClient;
    private String emailClient;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;
}
