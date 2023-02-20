package com.webgram.dao;
import com.webgram.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//jpaRepository est une classe qui gere la persistence  nous permettant de définir une
//interface de référentiel pour chaque entité de domaine de
//l’application.
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
//native
    //nomme
    @Query("select cat from Categorie cat where cat.isDeleted=false")
    List<Categorie>getAllCategorie();
}
