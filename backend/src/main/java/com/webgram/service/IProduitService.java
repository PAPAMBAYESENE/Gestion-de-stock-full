package com.webgram.service;

import com.webgram.entity.Categorie;
import com.webgram.entity.Produit;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    List<Produit> getAllProduit();
    Produit updateProduit(Long id,Produit produit);
    void  deletedProduit(Long id);
    Produit getOneProduit(Long id);
}
