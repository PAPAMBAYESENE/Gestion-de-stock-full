import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/model/categorie';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.scss']
})
export class UpdateCategorieComponent implements OnInit {
  idcategorie:any;

  categorie = this.fb.group({
    code:["", Validators.required],
    libelle:["",Validators.required]
          });


  constructor(private route:ActivatedRoute, private categorieService: CategorieService, private fb:FormBuilder,private router:Router){}
  ngOnInit(): void {
    
    this.idcategorie=this.route.snapshot.params["id"];
    this.categorieService.getoneCategorie(this.idcategorie).subscribe((data:any)=>{
      this.categorie.controls["code"].setValue(data.code);
      this.categorie.controls["libelle"].setValue(data.libelle);
      
    });

  }
  onsubmit(){
    this.categorieService.updateCategorie(this.idcategorie, this.categorie.value)
    .subscribe((data:any) =>{
      this.router.navigateByUrl("categorie");

    });
  }

}
