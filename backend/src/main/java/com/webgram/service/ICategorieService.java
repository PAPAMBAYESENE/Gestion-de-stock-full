package com.webgram.service;

import com.webgram.entity.Categorie;

import java.util.List;


public interface ICategorieService {
    Categorie addcategorie(Categorie categorie);
    List<Categorie> getAllCategorie();
    Categorie updateCategorie(Long id,Categorie categorie);
    void  deletedCategorie(Long id);
    Categorie getOneCategorie(Long id);
}
