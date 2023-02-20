package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//noargConstructor :generer un constructeur sans parametre
//AllargConstructor :generer un constructeur avec parametre contenant tout nos attribu
//@data:genere les setter et getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produits")
@Data
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    @Column(length = 5000)
    private String libelle;
    private  boolean isDeleted;
    @ManyToOne //dans plusieur produit nous pouvons avoir une categorie
    @JoinColumn(name = "categorieid")
    private  Categorie categorie;


}
