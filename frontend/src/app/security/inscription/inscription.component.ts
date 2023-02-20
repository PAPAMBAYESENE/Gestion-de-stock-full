import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {
  
  form: any = {
    firstname:null,
    lastname:null,
    email:null,
    password:null
  };
  isRegister = false;
  isRegisterFaled = false;
  errorMessage = "";

  constructor(private authService: AuthService, private router: Router) {   }

  ngOnInit(): void {
  }

  onSubmit(){
    const {firstname,lastname,email,password} = this.form;
    this.authService.inscription(firstname,lastname,email,password)
    .subscribe({
      next: data =>{
        console.log(data);
        this.isRegister = true;
        this.isRegisterFaled = false;
        this.router.navigateByUrl("/connexion");
      },
      error: err =>{
        this.errorMessage = err.error.message;
        this.isRegisterFaled = false;
      }
    });
  }

}
