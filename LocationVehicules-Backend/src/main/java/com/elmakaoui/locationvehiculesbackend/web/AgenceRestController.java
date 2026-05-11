package com.elmakaoui.locationvehiculesbackend.web;

import com.elmakaoui.locationvehiculesbackend.dtos.AgenceDTOS;
import com.elmakaoui.locationvehiculesbackend.exceptions.AgenceNotFoundException;
import com.elmakaoui.locationvehiculesbackend.services.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/agences")
@AllArgsConstructor
@CrossOrigin("*")
public class AgenceRestController {

    private RentalService rentalService;

    @GetMapping
    public List<AgenceDTOS> listAgences() {
        return rentalService.listAgences();
    }

    @GetMapping("/{id}")
    public AgenceDTOS getAgence(@PathVariable Long id) throws AgenceNotFoundException {
        return rentalService.getAgence(id);
    }

    @PostMapping
    public AgenceDTOS saveAgence(@RequestBody AgenceDTOS dto) {
        return rentalService.saveAgence(dto);
    }

    @PutMapping("/{id}")
    public AgenceDTOS updateAgence(@PathVariable Long id, @RequestBody AgenceDTOS dto)
            throws AgenceNotFoundException {
        return rentalService.updateAgence(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable Long id) {
        rentalService.deleteAgence(id);
    }
}
