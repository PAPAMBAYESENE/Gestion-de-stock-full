package com.webgram.dao;

import com.webgram.entity.Categorie;
import com.webgram.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Query("select pro from Produit pro where pro.isDeleted=false")
    List<Produit> getAllProduit();

}
