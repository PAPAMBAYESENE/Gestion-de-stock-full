import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  api: string  = environment.apiUrl;

  constructor( private http:HttpClient) { }

  addCategorie(categorie: any){
    return this.http.post(`${this.api}/addcategorie`,categorie);
  }
  getAllCategories() {
    return this.http.get(` ${this.api}/listeCategorie`);
  }
  updateCategorie(id:number, categorie:any){
    return this.http.put(`${this.api}/updatecat/${id}`,categorie);
  }
  deleteCategorie(id:number){
    return this.http.delete(`${this.api}/deletecat/${id}`);
  }
  getoneCategorie(id:number){
    return this.http.get(`${this.api}/getOneCategorie/${id}`);
  }
  
}
