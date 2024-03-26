package edu.devaux.chantier2.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.view.ChantierView;
import edu.devaux.chantier2.view.OperationView;
import edu.devaux.chantier2.view.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class})
    protected Integer id;

    @Column(nullable = false)
    @NotBlank
    @JsonView({UtilisateurView.class, ChantierView.class, OperationView.class})
    protected String pseudo;

    @Column(nullable = false)
    @NotBlank
    protected String motdepasse;

    @OneToMany(mappedBy = "utilisateur")
    @JsonView({UtilisateurView.class})
    protected List<Operation> operationList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    @JsonView({Utilisateur.class})
    protected List<Chantier> chantierList = new ArrayList<>();

    @ManyToOne(optional = false)
    @JsonView({UtilisateurView.class})
    protected Role role;




}



//Un utilisateur :
//possède un pseudo et un mot de passe
//possède un rôle (client, ouvrier, administrateur)