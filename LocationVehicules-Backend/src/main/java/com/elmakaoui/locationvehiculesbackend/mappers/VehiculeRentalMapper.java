package com.elmakaoui.locationvehiculesbackend.mappers;

import com.elmakaoui.locationvehiculesbackend.dtos.*;
import com.elmakaoui.locationvehiculesbackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VehiculeRentalMapper {

    public AgenceDTOS fromAgence(Agence agence) {
        AgenceDTOS agenceDTOS = new AgenceDTOS();
        BeanUtils.copyProperties(agence, agenceDTOS);
        return agenceDTOS;
    }

    public Agence fromAgenceDTO(AgenceDTOS agenceDTOS) {
        Agence agence = new Agence();
        BeanUtils.copyProperties(agenceDTOS, agence);
        return agence;
    }

    public VoitureDTOS fromVoiture(Voiture voiture) {
        VoitureDTOS voitureDTOS = new VoitureDTOS();
        BeanUtils.copyProperties(voiture, voitureDTOS);
        if (voiture.getAgence() != null)
            voitureDTOS.setAgenceId(voiture.getAgence().getId());
        return voitureDTOS;
    }

    public Voiture fromVoitureDTO(VoitureDTOS voitureDTOS) {
        Voiture voiture = new Voiture();
        BeanUtils.copyProperties(voitureDTOS, voiture);
        return voiture;
    }

    public MotoDTOS fromMoto(Moto moto) {
        MotoDTOS motoDTOS = new MotoDTOS();
        BeanUtils.copyProperties(moto, motoDTOS);
        if (moto.getAgence() != null)
            motoDTOS.setAgenceId(moto.getAgence().getId());
        return motoDTOS;
    }

    public Moto fromMotoDTO(MotoDTOS motoDTOS) {
        Moto moto = new Moto();
        BeanUtils.copyProperties(motoDTOS, moto);
        return moto;
    }

    public VehiculeDTOS fromVehicule(Vehicule vehicule) {
        if (vehicule instanceof Voiture voiture)
            return fromVoiture(voiture);
        if (vehicule instanceof Moto moto)
            return fromMoto(moto);
        throw new IllegalArgumentException("Type de vehicule inconnu: " + vehicule.getClass());
    }

    public LocationDTOS fromLocation(Location location) {
        LocationDTOS locationDTOS = new LocationDTOS();
        BeanUtils.copyProperties(location, locationDTOS);
        if (location.getVehicule() != null) {
            locationDTOS.setVehiculeId(location.getVehicule().getId());
            locationDTOS.setVehiculeMarque(location.getVehicule().getMarque());
            locationDTOS.setVehiculeModele(location.getVehicule().getModele());
        }
        return locationDTOS;
    }

    public Location fromLocationDTO(LocationDTOS locationDTOS) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTOS, location);
        return location;
    }
}