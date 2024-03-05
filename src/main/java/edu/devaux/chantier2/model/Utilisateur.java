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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String pseudo;
    protected String motdepasse;
    protected String role;

}



//Un utilisateur :
//possède un pseudo et un mot de passe
//possède un rôle (client, ouvrier, administrateur)