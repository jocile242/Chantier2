package edu.devaux.chantier2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.List;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Consommable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;


    @NotBlank(message = "le consommable ne peut etre sans valeur")
    @Size(min = 2, max = 100, message = "La valeur du consommable ne doit pas etre inferieur à 2 ou séperieur à 100")
    @Column(length = 100)
    protected String nom;
}


//Un consommable :
// à un nom
//peut être nécessaire à certaines tâche