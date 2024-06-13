export interface Pilot {
  id: number;
  nom: string;
  prenom: string;
  niveauActuel: number;
  number: number;
  price: number;
  force: number;
  endurance: number;
  coefficient: number;
  appartient: boolean;
  imagePilote: string;
}

export interface Engine {
  id: number;
  nomMoteur: string;
  consommationEssence: number;
  puissance: number;
  coefMoteur: number;
  prixMoteur: number;
  imageMoteur: string;
  nivActuel: number;
}

export interface Car {
  id : number
  poidsF1: number
  vitesseMax: number
  zeroTo100: number
  maniabilty: number
  coef: number
  imageF1: string
  appartient: boolean
  price : number
}
