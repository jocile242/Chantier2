package edu.devaux.chantier2.controller;

import edu.devaux.chantier2.dao.ChantierDao;
import edu.devaux.chantier2.model.Chantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


///  Mapping du chantier avec un DAO ///

@RestController
@CrossOrigin
public class ChantierController {
    @Autowired
    protected ChantierDao chantierDao;

    @GetMapping("/chantier/{id}")
    public Chantier get(@PathVariable int id) {
        return chantierDao.findById(id).orElse(null);
    }

    @GetMapping("/")
    public List<Chantier> getAllChantiers() {
        return chantierDao.findAll();
    }

    @PostMapping("/")
    public Chantier creerChantier(@RequestBody Chantier chantier) {
        return chantierDao.save(chantier);
    }
}


//Réaliser les Classes Tache , Operation et Consommable
// et les liaisons qui les concernent
//Ajouter des données de test afin de vérifier si tout fonctionne correctement
