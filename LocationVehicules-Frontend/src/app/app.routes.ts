import { Routes } from '@angular/router';
import { Agences } from './agences/agences';
import { Vehicules } from './vehicules/vehicules';
import { NewVehicule } from './new-vehicule/new-vehicule';
import { NewAgence } from './new-agence/new-agence';

export const routes: Routes = [
    { path:"agences", component: Agences},
    { path:"new-agences", component: NewAgence},
    { path:"vehicules", component: Vehicules},
    { path:"new-vehicules", component: NewVehicule},
];
