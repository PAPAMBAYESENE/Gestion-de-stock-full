import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  api = environment.apiUrl;

  constructor( private http:HttpClient) { }

  connexion(email: string,password:string){
    return this.http.post(`${this.api}/auth/login`, {email, password});
  }
  inscription(firstname:string, lastname:string, email:string, password:string) {
    return this.http.post(` ${this.api}/auth/register`, {firstname, lastname, email, password} );
  }
  deconnexion(){
    return this.http.post(`${this.api}/auth/deconnexion`,{});
  }
  deleteCategorie(id:number){
    return this.http.delete(`${this.api}/deletecat/${id}`);
  }
  getoneCategorie(id:number){
    return this.http.get(`${this.api}/getOneCategorie/${id}`);
  }

  
}
