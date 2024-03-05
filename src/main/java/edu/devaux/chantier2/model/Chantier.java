package edu.devaux.chantier2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chantier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nom;
    protected String adresse;
}

//Un chantier :
//possède une adresse
//est possédé par un client (un utilisateur)
//est dirigé par un ouvrier (un utilisateur)
//se voit planifier une liste d’opérations
