import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { VehiculeService } from '../services/VehiculeService';
import { Vehicule } from '../model/vehicule.model';

@Component({
  selector: 'app-vehicules',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './vehicules.html',
  styleUrl: './vehicules.css'
})
export class Vehicules implements OnInit {

  vehicules: Vehicule[] = [];
  errorMessage: string = '';

  constructor(private vehiculeService: VehiculeService) {}

  ngOnInit(): void {
    this.loadVehicules();
  }

  loadVehicules(): void {
    this.vehiculeService.getVehicules().subscribe({
      next: (data) => {
        this.vehicules = data;
        this.errorMessage = '';
      },
      error: (err) => {
        this.errorMessage = 'Erreur de chargement: ' + err.message;
        console.error(err);
      }
    });
  }

  handleDeleteVehicule(vehicule: Vehicule): void {
    if (!confirm(`Supprimer ${vehicule.marque} ${vehicule.modele} ?`)) return;

    this.vehiculeService.deleteVehicule(vehicule.id!).subscribe({
      next: () => {
        this.vehicules = this.vehicules.filter(v => v.id !== vehicule.id);
      },
      error: (err) => {
        this.errorMessage = 'Erreur de suppression: ' + err.message;
        console.error(err);
      }
    });
  }

  getStatusBadgeClass(statut: string): string {
    switch (statut) {
      case 'DISPONIBLE': return 'badge bg-success';
      case 'LOUE': return 'badge bg-warning text-dark';
      case 'EN_MAINTENANCE': return 'badge bg-danger';
      default: return 'badge bg-secondary';
    }
  }
}
