import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { VehiculeService } from '../services/VehiculeService';
import { AgenceService } from '../services/AgenceService';
import { Agence } from '../model/agence.model';
import { Voiture, Moto, StatutVehicule, TypeCarburant, BoiteVitesse, TypeMoto } from '../model/vehicule.model';

@Component({
  selector: 'app-new-vehicule',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './new-vehicule.html',
  styleUrl: './new-vehicule.css'
})
export class NewVehicule implements OnInit {

  newVehiculeForm!: FormGroup;
  errorMessage: string = '';
  agences: Agence[] = [];

  statutOptions = Object.values(StatutVehicule);
  carburantOptions = Object.values(TypeCarburant);
  boiteOptions = Object.values(BoiteVitesse);
  typeMotoOptions = Object.values(TypeMoto);

  constructor(
    private fb: FormBuilder,
    private vehiculeService: VehiculeService,
    private agenceService: AgenceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.newVehiculeForm = this.fb.group({
      type:              ['VOITURE', Validators.required],
      marque:            ['', Validators.required],
      modele:            ['', Validators.required],
      matricule:         ['', Validators.required],
      prixParJour:       [0, [Validators.required, Validators.min(1)]],
      dateMiseEnService: [new Date().toISOString().substring(0, 10), Validators.required],
      statut:            [StatutVehicule.DISPONIBLE, Validators.required],
      agenceId:          [null, Validators.required],

      nombrePortes:  [4],
      typeCarburant: [TypeCarburant.ESSENCE],
      boiteVitesse:  [BoiteVitesse.MANUELLE],

      cylindree:     [125],
      typeMoto:      [TypeMoto.SCOOTER],
      casqueInclus:  [false]
    });

    this.agenceService.getAgences().subscribe({
      next: (data) => {
        this.agences = data;
        if (data.length > 0) {
          this.newVehiculeForm.patchValue({ agenceId: data[0].id });
        }
      },
      error: (err) => {
        this.errorMessage = 'Impossible de charger les agences: ' + err.message;
      }
    });
  }

  get selectedType(): string {
    return this.newVehiculeForm.get('type')?.value;
  }

  handleSaveVehicule(): void {
    if (this.newVehiculeForm.invalid) return;

    const value = this.newVehiculeForm.value;

    if (value.type === 'VOITURE') {
      const voiture: Voiture = {
        type: 'VOITURE',
        marque: value.marque,
        modele: value.modele,
        matricule: value.matricule,
        prixParJour: value.prixParJour,
        dateMiseEnService: value.dateMiseEnService,
        statut: value.statut,
        agenceId: value.agenceId,
        nombrePortes: value.nombrePortes,
        typeCarburant: value.typeCarburant,
        boiteVitesse: value.boiteVitesse
      };
      this.vehiculeService.saveVoiture(voiture).subscribe({
        next: () => {
          alert('Voiture ajoutée avec succès !');
          this.router.navigateByUrl('/vehicules');
        },
        error: (err) => {
          this.errorMessage = 'Erreur: ' + err.message;
          console.error(err);
        }
      });
    } else {
      const moto: Moto = {
        type: 'MOTO',
        marque: value.marque,
        modele: value.modele,
        matricule: value.matricule,
        prixParJour: value.prixParJour,
        dateMiseEnService: value.dateMiseEnService,
        statut: value.statut,
        agenceId: value.agenceId,
        cylindree: value.cylindree,
        typeMoto: value.typeMoto,
        casqueInclus: value.casqueInclus
      };
      this.vehiculeService.saveMoto(moto).subscribe({
        next: () => {
          alert('Moto ajoutée avec succès !');
          this.router.navigateByUrl('/vehicules');
        },
        error: (err) => {
          this.errorMessage = 'Erreur: ' + err.message;
          console.error(err);
        }
      });
    }
  }
}
