package com.webgram.service.ImplementCategorie;

import com.webgram.dao.CategorieRepository;
import com.webgram.entity.Categorie;
import com.webgram.service.ICategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor //permet de faire l'injection de dépendance par constructeur qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc..
public class CategorieServiceImpl implements ICategorieService {
    private final CategorieRepository categorieRepository; //variable utilisés pour gérer l'injection de dépendance par constructeur de type la classe qui etend jparepository
    @Override
    public Categorie addcategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.getAllCategorie();
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie categorie) {
    Categorie existingcat=getOneCategorie(id);
    existingcat.setCode(categorie.getCode());
    existingcat.setLibelle(categorie.getLibelle());
    return categorieRepository.save(existingcat);

    }

    @Override
    public void deletedCategorie(Long id) {
        Categorie existingcat=getOneCategorie(id);
        categorieRepository.delete (existingcat);
    }

    @Override
    public Categorie getOneCategorie(Long id) {
        return categorieRepository.findById(id).orElseThrow(()->new RuntimeException("La categorie recherché n'existe pas"));
    }
}
