package com.webgram.web;

import com.webgram.entity.Categorie;
import com.webgram.service.ImplementCategorie.CategorieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Dans chaque api il est impératif davoir lanotation @RestController si cest une api rest
@CrossOrigin
@RestController //Une api permet a nimporte quelle interface front(mobile ou web postman) d'accéder a nos methodess serviceimpl
@RequiredArgsConstructor //permet de faire l'injection de dépendance par constructeur qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc.. Mais pour ce cas comme nous avions déja mentionné save() et get.. dans la classe service on crée juste une variable de type la classe de service et on appelle les méthode api pour le crud
//@RequestMapping permet de nous faciliter la tache dans les url de @PostMapping("/api/webgram/v1//addcategorie")
@RequestMapping("/api/webgram/v1")
public class CategorieController {
    private final CategorieServiceImpl catService; // //variable utilisés pour gérer l'injection de dépendance par constructeur de type la classe service avec laquelle nous avons fait l'injection de dépendance par constructeur de type la classe qui etend jparepository
    @PostMapping("/addcategorie")
    public ResponseEntity<Categorie> newcategorie(@RequestBody Categorie categorie){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Categorie cat=catService.addcategorie(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }
    @GetMapping("/listcategorie")
    public ResponseEntity<List<Categorie>> listcategorie(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(catService.getAllCategorie());
    }

    @PutMapping("/updatecategorie/{id}")
    public ResponseEntity<Categorie> updatecategorie(@PathVariable Long id, @RequestBody Categorie categorie){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Categorie cat=catService.updateCategorie(id,categorie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
    }

    @DeleteMapping("/deletecategorie/{id}")
    public ResponseEntity<Categorie> deletecategorie(@PathVariable Long id){
        catService.deletedCategorie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOneCategorie/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id){
        return ResponseEntity.ok(catService.getOneCategorie(id));
    }
}
