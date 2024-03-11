package edu.devaux.chantier2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nom;
    protected LocalDate date;
}


//Une opération :
// est planifiée pour un chantier à une date donnée
//concerne une tâche
//est affecté à un ouvrier (un utilisateur)