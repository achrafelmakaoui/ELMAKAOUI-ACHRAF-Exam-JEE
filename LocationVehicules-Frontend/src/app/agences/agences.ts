import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AgenceService } from '../services/AgenceService';
import { Agence } from '../model/agence.model';

@Component({
  selector: 'app-agences',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './agences.html',
  styleUrl: './agences.css'
})
export class Agences implements OnInit {

  agences: Agence[] = [];
  errorMessage: string = '';

  constructor(private agenceService: AgenceService) {}

  ngOnInit(): void {
    this.loadAgences();
  }

  loadAgences(): void {
    this.agenceService.getAgences().subscribe({
      next: (data) => {
        this.agences = data;
        this.errorMessage = '';
      },
      error: (err) => {
        this.errorMessage = 'Erreur de chargement: ' + err.message;
        console.error(err);
      }
    });
  }

  handleDeleteAgence(agence: Agence): void {
    let conf = confirm("Are You Sure?");
    if (!conf) return;
    this.agenceService.deleteAgence(agence.id).subscribe({
      next : (resp) => {
        this.loadAgences;
      }, error: err => {
        console.log(err);
      }
    })
  }
  
}