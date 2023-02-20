import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Route, Router } from '@angular/router';
import { AddCategorieComponent } from '../add-categorie/add-categorie.component';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent implements AfterViewInit,OnInit
{
  displayedColumns: string[] = ['id', 'code', 'libelle', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private categorieservice:CategorieService,public dialog: MatDialog, private route:Router){}
  
  ngOnInit(): void {
    this.getAllCategorie();
  }
  
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();  }
  getAllCategorie()
  {
  this.categorieservice.getAllCategories().subscribe({ 
    next:(data:any)=>{
      this.dataSource=data;
  

    },
    error:err=>{

    }
    
  })
  }
  openDialogAddcategorie(){
    const dialogRef = this.dialog.open(AddCategorieComponent);

    dialogRef.afterClosed().subscribe(result => {
      this.getAllCategorie();
    });
  }

  oneDeleteCategorie(row:number){
    this.categorieservice.deleteCategorie(row).subscribe((data:any)=>{
      if(data == null) {
        this.getAllCategorie();
      }
    });
  }

  
  onupdateCategorie(id:number)
  {
    this.route.navigateByUrl(`/updatecat/${id}`);
  }


}
