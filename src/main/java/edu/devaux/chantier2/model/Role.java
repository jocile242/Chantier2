package edu.devaux.chantier2.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.view.UtilisateurView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class})
    protected Integer id;

    @NotBlank(message = "Le role ne peut pas etre vide")
    @Size(min = 2, max = 100, message = "La role ne peut être inférieur à 2 ou supérieur à 100")
    @JsonView({UtilisateurView.class})
    @Column(length = 100)
    protected String designation;

    @OneToMany(mappedBy = "role")
    protected List<Utilisateur> utilisateurList = new ArrayList<>();

}
