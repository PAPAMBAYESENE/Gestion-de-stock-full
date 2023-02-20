import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent {
  categorie=this.fb.group({
    code:[" " ,Validators.required],
    libelle:[" ", Validators.required]
  });
  constructor(private fb:FormBuilder, private categorieservice:CategorieService ){}
  onsubmit(){
    this.categorieservice.addCategorie(this.categorie.value)
    .subscribe((data:any) =>{

    });
  }
  

}
