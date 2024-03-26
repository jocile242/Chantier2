package edu.devaux.chantier2.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.view.ChantierView;
import edu.devaux.chantier2.view.OperationView;
import edu.devaux.chantier2.view.TacheView;
import edu.devaux.chantier2.view.UtilisateurView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, TacheView.class, ChantierView.class, OperationView.class})
    protected Integer id;

    @NotBlank(message = "L'operation ne peut pas etre vide")
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "L'opération ne peut pas être inférieur à 2 ou supérieur à 100")
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class, TacheView.class})
    protected String nom;

    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class, TacheView.class})
    protected LocalDate date;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected Utilisateur utilisateur;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected Tache tache;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected Chantier chantier;

}


//Une opération :
// est planifiée pour un chantier à une date donnée
//concerne une tâche
//est affecté à un ouvrier (un utilisateur)