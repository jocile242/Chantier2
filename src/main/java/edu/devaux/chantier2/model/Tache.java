package edu.devaux.chantier2.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.view.OperationView;
import edu.devaux.chantier2.view.TacheView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Size(min = 2, max = 100, message = "La tache ne peut être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    @NotBlank(message = "Le nom de la tâche ne peut être vide")
    @JsonView({OperationView.class, TacheView.class})
    protected String nom;

    @Min(value = 0, message = "Le temps de la tache ne peut etre inférieur ou égal à 0")
    @JsonView({OperationView.class, TacheView.class})
    protected Integer temps;

    @ManyToMany
    protected Consommable consommable;
}
