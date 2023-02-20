import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieComponent } from './categorie/categorie.component';
import { HomeComponent } from './home/home.component';
import { ProduitComponent } from './produit/produit.component';
import { InscriptionComponent } from './security/inscription/inscription.component';
import { LoginComponent } from './security/login/login.component';
import { UpdateCategorieComponent } from './update-categorie/update-categorie.component';

const routes: Routes = [
  {path: "home", component : HomeComponent},
  {path: "categorie", component : CategorieComponent},
  {path: "produit", component : ProduitComponent},
  {path: "updatecat/:id", component : UpdateCategorieComponent},
  {path: "connexion",component: LoginComponent},
  {path: "inscription",component: InscriptionComponent},
  {path : "**", redirectTo :"connexion",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
