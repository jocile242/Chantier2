package edu.devaux.chantier2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.dao.ChantierDao;
import edu.devaux.chantier2.model.Chantier;
import edu.devaux.chantier2.view.ChantierView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


///  Mapping du chantier avec un DAO ///

@RestController
@AllArgsConstructor
public class ChantierController {

    @Autowired
    protected ChantierDao chantierDao;

    @GetMapping("/chantier/{id}")
    //Ne pas oublié d'ajouter le view de chantier

    @JsonView(ChantierView.class)
    public ResponseEntity<Chantier> get(@PathVariable int id) {

        Optional<Chantier> chantierOptional = chantierDao.findById(id);

            if (chantierOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(chantierOptional.get(), HttpStatus.OK);
        }
        @GetMapping("/chantier/list")
        @JsonView(ChantierView.class)
        public List<Chantier> list () {
            return chantierDao.findAll();
        }
        @PostMapping("/chantier")
        @JsonView(ChantierView.class)
        public ResponseEntity<Chantier> add (@Valid @RequestBody Chantier newChantier){
            if (newChantier.getId() != null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            chantierDao.save(newChantier);
            return new ResponseEntity<>(newChantier, HttpStatus.CREATED);
        }
        @PutMapping("/chantier/{id}")
        @JsonView(ChantierView.class)
        public ResponseEntity<Chantier> modifier (@Valid @RequestBody Chantier chantier,@PathVariable int id){
            chantier.setId(id);

            Optional<Chantier> chantierOptional = chantierDao.findById(chantier.getId());

            if (chantierOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            chantierDao.save(chantier);
            return new ResponseEntity<>(chantierOptional.get(), HttpStatus.OK);
        }

        @DeleteMapping("/chantier/{id}")
        @JsonView(ChantierView.class)
        public ResponseEntity<Chantier> delete ( @PathVariable int id){
            Optional<Chantier> chantierOptional = chantierDao.findById(id);

            if (chantierOptional.isPresent()) {
                chantierDao.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


//Réaliser les Classes Tache , Operation et Consommable
// et les liaisons qui les concernent
//Ajouter des données de test afin de vérifier si tout fonctionne correctement
