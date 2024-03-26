package edu.devaux.chantier2.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.view.ChantierView;
import edu.devaux.chantier2.view.OperationView;
import edu.devaux.chantier2.view.UtilisateurView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Chantier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class})
    protected Integer id;

    @NotBlank(message = "Le nom ne doit pas etre vide")
    @Size(max = 100, message = "Nom à maximum 100 caractères") //ConstraintViolationException en cas d'erreur
    @Column(length = 100)
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class})
    protected String nom;

    @Size(min = 2, max = 100, message = "le Chantier ne doit pas avoir une valeur en dessous de 2 ou supérieur à 100")
    @Column(length = 100)
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class})
    protected String adresse;

    @OneToMany(mappedBy = "chantier")
    @JsonView({ChantierView.class})
    protected List<Operation> operationList = new ArrayList<>();

    @ManyToOne(optional = false)
    @JsonView({ChantierView.class})
    protected Utilisateur utilisateur;

}


//Un chantier :
//possède une adresse
//est possédé par un client (un utilisateur)
//est dirigé par un ouvrier (un utilisateur)
//se voit planifier une liste d’opérations