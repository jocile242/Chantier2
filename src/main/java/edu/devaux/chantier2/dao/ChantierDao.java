package edu.devaux.chantier2.dao;

import edu.devaux.chantier2.model.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChantierDao extends JpaRepository <Chantier,Integer> {
}
