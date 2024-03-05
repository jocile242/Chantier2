package edu.devaux.chantier2.dao;

import edu.devaux.chantier2.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository <Utilisateur,Integer> {
}