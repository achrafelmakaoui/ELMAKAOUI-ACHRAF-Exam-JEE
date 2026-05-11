import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicule, Voiture, Moto } from '../model/vehicule.model';

@Injectable({ providedIn: 'root' })
export class VehiculeService {

  private apiUrl: string = 'http://localhost:8085/vehicules';

  constructor(private http: HttpClient) {}

  // ----- READ -----
  getVehicules(): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(this.apiUrl);
  }

  getVehiculeById(id: number): Observable<Vehicule> {
    return this.http.get<Vehicule>(`${this.apiUrl}/${id}`);
  }

  getVehiculesByAgence(agenceId: number): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.apiUrl}/agence/${agenceId}`);
  }

  getVehiculesDisponibles(): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.apiUrl}/disponibles`);
  }

  saveVoiture(voiture: Voiture): Observable<Voiture> {
    return this.http.post<Voiture>(`${this.apiUrl}/voitures`, voiture);
  }

  saveMoto(moto: Moto): Observable<Moto> {
    return this.http.post<Moto>(`${this.apiUrl}/motos`, moto);
  }

  deleteVehicule(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
