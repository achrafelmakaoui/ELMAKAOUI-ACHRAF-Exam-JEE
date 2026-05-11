export enum StatutVehicule {
  DISPONIBLE = 'DISPONIBLE',
  LOUE = 'LOUE',
  EN_MAINTENANCE = 'EN_MAINTENANCE'
}

export enum TypeCarburant {
  ESSENCE = 'ESSENCE',
  DIESEL = 'DIESEL',
  HYBRIDE = 'HYBRIDE',
  ELECTRIQUE = 'ELECTRIQUE'
}

export enum BoiteVitesse {
  MANUELLE = 'MANUELLE',
  AUTOMATIQUE = 'AUTOMATIQUE'
}

export enum TypeMoto {
  SPORTIVE = 'SPORTIVE',
  SCOOTER = 'SCOOTER',
  ROADSTER = 'ROADSTER',
  TOURING = 'TOURING'
}

export interface Vehicule {
  id?: number;
  type?: string;
  marque: string;
  modele: string;
  matricule: string;
  prixParJour: number;
  dateMiseEnService?: string | Date;
  statut: StatutVehicule;
  agenceId: number;

  nombrePortes?: number;
  typeCarburant?: TypeCarburant;
  boiteVitesse?: BoiteVitesse;

  cylindree?: number;
  typeMoto?: TypeMoto;
  casqueInclus?: boolean;
}

export interface Voiture {
  type: 'VOITURE';
  id?: number;
  marque: string;
  modele: string;
  matricule: string;
  prixParJour: number;
  dateMiseEnService?: string | Date;
  statut: StatutVehicule;
  agenceId: number;
  nombrePortes: number;
  typeCarburant: TypeCarburant;
  boiteVitesse: BoiteVitesse;
}


export interface Moto {
  type: 'MOTO';
  id?: number;
  marque: string;
  modele: string;
  matricule: string;
  prixParJour: number;
  dateMiseEnService?: string | Date;
  statut: StatutVehicule;
  agenceId: number;
  cylindree: number;
  typeMoto: TypeMoto;
  casqueInclus: boolean;
}
