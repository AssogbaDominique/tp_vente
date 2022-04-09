package com.defi.tp_vente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = xxx)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "ArticleId")
    private int id;
    private String libelle;
    private double prix;
    private int qteStock;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateCreation;
    private int qteSeuil;
    @ManyToOne
    @JoinColumn(name = "categorie_id",insertable = false,updatable = false)
    private Categorie categorie;
    private int categorie_id;
}
