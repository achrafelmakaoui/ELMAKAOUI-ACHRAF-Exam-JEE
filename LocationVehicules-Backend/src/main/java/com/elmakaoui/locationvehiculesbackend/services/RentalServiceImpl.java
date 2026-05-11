package com.elmakaoui.locationvehiculesbackend.services;

import com.elmakaoui.locationvehiculesbackend.dtos.*;
import com.elmakaoui.locationvehiculesbackend.entities.*;
import com.elmakaoui.locationvehiculesbackend.enums.StatutVehicule;
import com.elmakaoui.locationvehiculesbackend.exceptions.AgenceNotFoundException;
import com.elmakaoui.locationvehiculesbackend.exceptions.VehiculeNotFoundException;
import com.elmakaoui.locationvehiculesbackend.mappers.VehiculeRentalMapper;
import com.elmakaoui.locationvehiculesbackend.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RentalServiceImpl implements RentalService {

    private AgenceRepository agenceRepository;
    private VehiculeRepository vehiculeRepository;
    private VoitureRepository voitureRepository;
    private MotoRepository motoRepository;
    private LocationRepository locationRepository;
    private VehiculeRentalMapper mapper;


    @Override
    public AgenceDTOS saveAgence(AgenceDTOS dto) {
        log.info("Saving new agence: {}", dto.getNom());
        Agence saved = agenceRepository.save(mapper.fromAgenceDTO(dto));
        return mapper.fromAgence(saved);
    }

    @Override
    public List<AgenceDTOS> listAgences() {
        return agenceRepository.findAll().stream()
                .map(mapper::fromAgence)
                .collect(Collectors.toList());
    }

    @Override
    public AgenceDTOS getAgence(Long id) throws AgenceNotFoundException {
        Agence a = agenceRepository.findById(id)
                .orElseThrow(() -> new AgenceNotFoundException("Agence not found: " + id));
        return mapper.fromAgence(a);
    }

    @Override
    public AgenceDTOS updateAgence(Long id, AgenceDTOS dto) throws AgenceNotFoundException {
        Agence existing = agenceRepository.findById(id)
                .orElseThrow(() -> new AgenceNotFoundException("Agence not found: " + id));
        existing.setNom(dto.getNom());
        existing.setAdresse(dto.getAdresse());
        existing.setVille(dto.getVille());
        existing.setTelephone(dto.getTelephone());
        return mapper.fromAgence(agenceRepository.save(existing));
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public VoitureDTOS saveVoiture(VoitureDTOS dto) throws AgenceNotFoundException {
        Voiture v = mapper.fromVoitureDTO(dto);
        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new AgenceNotFoundException("Agence not found"));
            v.setAgence(agence);
        }
        if (v.getStatut() == null) v.setStatut(StatutVehicule.DISPONIBLE);
        return mapper.fromVoiture(voitureRepository.save(v));
    }

    @Override
    public MotoDTOS saveMoto(MotoDTOS dto) throws AgenceNotFoundException {
        Moto m = mapper.fromMotoDTO(dto);
        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new AgenceNotFoundException("Agence not found"));
            m.setAgence(agence);
        }
        if (m.getStatut() == null) m.setStatut(StatutVehicule.DISPONIBLE);
        return mapper.fromMoto(motoRepository.save(m));
    }

    @Override
    public List<VehiculeDTOS> listVehicules() {
        return vehiculeRepository.findAll().stream()
                .map(mapper::fromVehicule)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTOS getVehicule(Long id) throws VehiculeNotFoundException {
        Vehicule v = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException("Vehicule not found: " + id));
        return mapper.fromVehicule(v);
    }

    @Override
    public List<VehiculeDTOS> getVehiculesByAgence(Long agenceId) {
        return vehiculeRepository.findByAgenceId(agenceId).stream()
                .map(mapper::fromVehicule)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculeDTOS> getVehiculesDisponibles() {
        return vehiculeRepository.findByStatut(StatutVehicule.DISPONIBLE).stream()
                .map(mapper::fromVehicule)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}
