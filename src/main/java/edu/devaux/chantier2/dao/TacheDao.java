package edu.devaux.chantier2.dao;


import edu.devaux.chantier2.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheDao extends JpaRepository <Tache,Integer>{
        }
