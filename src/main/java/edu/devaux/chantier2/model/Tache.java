package edu.devaux.chantier2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nom;
    protected Integer temps;

    @ManyToOne
    @JoinColumn(name = "chantier_id", referencedColumnName = "id", columnDefinition = "INTEGER")
    protected Chantier chantier;

    @OneToMany(mappedBy = "tache")
    protected List<Consommable> consommables = new ArrayList<>();
}