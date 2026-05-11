import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Agence } from '../model/agence.model'

@Injectable({
  providedIn: 'root',
})
export class AgenceService {
  backendHost:string = "http://localhost:8085"
  constructor(private http:HttpClient) { }

  public getAgences(): Observable<Agence[]> {
    return this.http.get<Array<Agence>>(this.backendHost + "/agences")
  }
  getAgenceById(id: number): Observable<Agence> {
    return this.http.get<Agence>(this.backendHost + "/agences/" + id);
  }

  public saveAgence(agence: Agence): Observable<Agence> {
    return this.http.post<Agence>(this.backendHost + "/agences", agence)
  }

  public deleteAgence(id: number): Observable<any> {
    return this.http.delete(this.backendHost + "/agences/" + id)
  }
} 



