// =============================================================
// NEW AGENCE — reactive form to create an agence
// =============================================================
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder, FormGroup, ReactiveFormsModule, Validators
} from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AgenceService } from '../services/AgenceService';

@Component({
  selector: 'app-new-agence',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './new-agence.html',
  styleUrl: './new-agence.css'
})
export class NewAgence {

  newAgenceForm!: FormGroup;
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private agenceService: AgenceService,
    private router: Router
  ) {
    this.newAgenceForm = this.fb.group({
      nom:       ['', [Validators.required, Validators.minLength(2)]],
      adresse:   ['', [Validators.required]],
      ville:     ['', [Validators.required]],
      telephone: ['', [Validators.required, Validators.pattern(/^[0-9+\- ]{8,15}$/)]]
    });
  }

  handleSaveAgence(): void {
    if (this.newAgenceForm.invalid) return;

    this.agenceService.saveAgence(this.newAgenceForm.value).subscribe({
      next: () => {
        alert('Agence ajoutée avec succès !');
        this.router.navigateByUrl('/agences');
      },
      error: (err) => {
        this.errorMessage = 'Erreur: ' + err.message;
        console.error(err);
      }
    });
  }
}
