package edu.devaux.chantier2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.dao.TacheDao;
import edu.devaux.chantier2.model.Tache;
import edu.devaux.chantier2.view.TacheView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TacheController {

    TacheDao tacheDao;

    @Autowired
    public TacheController(TacheDao tacheDao){this.tacheDao = tacheDao;}

        @GetMapping("/tache/{id}")
        @JsonView(TacheView.class)
        public ResponseEntity<Tache> get(@PathVariable int id){

            Optional<Tache> tacheOptional = tacheDao.findById(id);

            if(tacheOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tacheOptional.get(), HttpStatus.OK);

        }

        @GetMapping("/tache/list")
        @JsonView(TacheView.class)
        public List<Tache> list(){
            return tacheDao.findAll();
        }
        @PostMapping("/tache")
        @JsonView(TacheView.class)
        public String add(@RequestBody Tache newTache){

            this.tacheDao.save(newTache);
            return "Utilisateur sauvegardé";
        }
        @DeleteMapping("/tache/{id}")
        @JsonView(TacheView.class)
        public ResponseEntity<Tache> delete(@PathVariable int id){
            Optional<Tache> tacheToDelete = tacheDao.findById(id);
            if(tacheToDelete.isPresent()){
                tacheDao.deleteById(id);
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }
    }

