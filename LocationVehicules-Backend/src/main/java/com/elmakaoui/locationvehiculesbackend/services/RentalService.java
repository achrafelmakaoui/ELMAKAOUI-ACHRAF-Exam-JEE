package com.elmakaoui.locationvehiculesbackend.services;

import com.elmakaoui.locationvehiculesbackend.dtos.*;
import com.elmakaoui.locationvehiculesbackend.exceptions.AgenceNotFoundException;
import com.elmakaoui.locationvehiculesbackend.exceptions.LocationNotFoundException;
import com.elmakaoui.locationvehiculesbackend.exceptions.VehiculeNonDisponibleException;
import com.elmakaoui.locationvehiculesbackend.exceptions.VehiculeNotFoundException;

import java.util.List;

public interface RentalService {
    AgenceDTOS saveAgence(AgenceDTOS agenceDTOS);
    List<AgenceDTOS> listAgences();
    AgenceDTOS getAgence(Long id) throws AgenceNotFoundException;
    AgenceDTOS updateAgence(Long id, AgenceDTOS agenceDTOS) throws AgenceNotFoundException;
    void deleteAgence(Long id);

    VoitureDTOS saveVoiture(VoitureDTOS voitureDTOS) throws AgenceNotFoundException;
    MotoDTOS saveMoto(MotoDTOS motoDTOS)       throws AgenceNotFoundException;
    List<VehiculeDTOS> listVehicules();
    VehiculeDTOS getVehicule(Long id) throws VehiculeNotFoundException;
    List<VehiculeDTOS> getVehiculesByAgence(Long agenceId);
    List<VehiculeDTOS> getVehiculesDisponibles();
    void deleteVehicule(Long id);
}
