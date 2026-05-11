package com.elmakaoui.locationvehiculesbackend;

import com.elmakaoui.locationvehiculesbackend.dtos.AgenceDTOS;
import com.elmakaoui.locationvehiculesbackend.dtos.MotoDTOS;
import com.elmakaoui.locationvehiculesbackend.dtos.VoitureDTOS;
import com.elmakaoui.locationvehiculesbackend.entities.AppUser;
import com.elmakaoui.locationvehiculesbackend.enums.BoiteVitesse;
import com.elmakaoui.locationvehiculesbackend.enums.StatutVehicule;
import com.elmakaoui.locationvehiculesbackend.enums.TypeCarburant;
import com.elmakaoui.locationvehiculesbackend.enums.TypeMoto;
import com.elmakaoui.locationvehiculesbackend.repositories.AppUserRepository;
import com.elmakaoui.locationvehiculesbackend.services.RentalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LocationVehiculesBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationVehiculesBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(RentalService rentalService,
                               AppUserRepository userRepository) {
        return args -> {
            AgenceDTOS a1 = new AgenceDTOS();
            a1.setNom("AutoLoc Casablanca");
            a1.setAdresse("Bd Mohammed V, 123");
            a1.setVille("Casablanca");
            a1.setTelephone("0522112233");
            AgenceDTOS savedA1 = rentalService.saveAgence(a1);

            AgenceDTOS a2 = new AgenceDTOS();
            a2.setNom("AutoLoc Rabat");
            a2.setAdresse("Avenue Hassan II, 45");
            a2.setVille("Rabat");
            a2.setTelephone("0537998877");
            AgenceDTOS savedA2 = rentalService.saveAgence(a2);

            VoitureDTOS v1 = new VoitureDTOS();
            v1.setMarque("Toyota");
            v1.setModele("Corolla");
            v1.setMatricule("123-A-45");
            v1.setPrixParJour(250.0);
            v1.setDateMiseEnService(new Date());
            v1.setStatut(StatutVehicule.DISPONIBLE);
            v1.setAgenceId(savedA1.getId());
            v1.setNombrePortes(4);
            v1.setTypeCarburant(TypeCarburant.ESSENCE);
            v1.setBoiteVitesse(BoiteVitesse.AUTOMATIQUE);
            rentalService.saveVoiture(v1);

            VoitureDTOS v2 = new VoitureDTOS();
            v2.setMarque("Renault");
            v2.setModele("Clio");
            v2.setMatricule("456-B-12");
            v2.setPrixParJour(180.0);
            v2.setDateMiseEnService(new Date());
            v2.setStatut(StatutVehicule.DISPONIBLE);
            v2.setAgenceId(savedA1.getId());
            v2.setNombrePortes(5);
            v2.setTypeCarburant(TypeCarburant.DIESEL);
            v2.setBoiteVitesse(BoiteVitesse.MANUELLE);
            rentalService.saveVoiture(v2);

            // ===== Motos =====
            MotoDTOS m1 = new MotoDTOS();
            m1.setMarque("Yamaha");
            m1.setModele("MT-07");
            m1.setMatricule("789-M-01");
            m1.setPrixParJour(150.0);
            m1.setDateMiseEnService(new Date());
            m1.setStatut(StatutVehicule.DISPONIBLE);
            m1.setAgenceId(savedA2.getId());
            m1.setCylindree(689);
            m1.setTypeMoto(TypeMoto.ROADSTER);
            m1.setCasqueInclus(true);
            rentalService.saveMoto(m1);

            MotoDTOS m2 = new MotoDTOS();
            m2.setMarque("Honda");
            m2.setModele("PCX 125");
            m2.setMatricule("321-M-02");
            m2.setPrixParJour(80.0);
            m2.setDateMiseEnService(new Date());
            m2.setStatut(StatutVehicule.DISPONIBLE);
            m2.setAgenceId(savedA2.getId());
            m2.setCylindree(125);
            m2.setTypeMoto(TypeMoto.SCOOTER);
            m2.setCasqueInclus(false);
            rentalService.saveMoto(m2);
        };
    }
}
