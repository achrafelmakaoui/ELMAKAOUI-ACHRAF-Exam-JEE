package com.elmakaoui.locationvehiculesbackend.web;

import com.elmakaoui.locationvehiculesbackend.dtos.MotoDTOS;
import com.elmakaoui.locationvehiculesbackend.dtos.VehiculeDTOS;
import com.elmakaoui.locationvehiculesbackend.dtos.VoitureDTOS;
import com.elmakaoui.locationvehiculesbackend.exceptions.AgenceNotFoundException;
import com.elmakaoui.locationvehiculesbackend.exceptions.VehiculeNotFoundException;
import com.elmakaoui.locationvehiculesbackend.services.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@AllArgsConstructor
@CrossOrigin("*")
public class VehiculeRestController {

    private RentalService rentalService;

    @GetMapping
    public List<VehiculeDTOS> listVehicules() {
        return rentalService.listVehicules();
    }

    @GetMapping("/{id}")
    public VehiculeDTOS getVehicule(@PathVariable Long id) throws VehiculeNotFoundException {
        return rentalService.getVehicule(id);
    }

    @GetMapping("/agence/{agenceId}")
    public List<VehiculeDTOS> byAgence(@PathVariable Long agenceId) {
        return rentalService.getVehiculesByAgence(agenceId);
    }

    @GetMapping("/disponibles")
    public List<VehiculeDTOS> disponibles() {
        return rentalService.getVehiculesDisponibles();
    }

    @PostMapping("/voitures")
    public VoitureDTOS saveVoiture(@RequestBody VoitureDTOS dto) throws AgenceNotFoundException {
        return rentalService.saveVoiture(dto);
    }

    @PostMapping("/motos")
    public MotoDTOS saveMoto(@RequestBody MotoDTOS dto) throws AgenceNotFoundException {
        return rentalService.saveMoto(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        rentalService.deleteVehicule(id);
    }
}
