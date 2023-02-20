package com.webgram.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

//noargConstructor :generer un constructeur sans parametre
//AllargConstructor :generer un constructeur avec parametre contenant tout nos attribu
//@data:genere les setter et getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data// sans @Data les setter et les getter ne serons pas visible déhors
@Table(name = "Category")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "Codes", length = 3,nullable = false)
    private String code;
    private String libelle;
    private  boolean isDeleted=false;
    @OneToMany(mappedBy = "categorie") //Une categorie peut avoir plusieur produit
    private List<Produit> produits;



}
