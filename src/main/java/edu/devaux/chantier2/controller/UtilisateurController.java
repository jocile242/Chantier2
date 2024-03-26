package edu.devaux.chantier2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.dao.UtilisateurDao;
import edu.devaux.chantier2.model.Utilisateur;
import edu.devaux.chantier2.view.UtilisateurView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    private final UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(id);
        return utilisateurOptional.map(utilisateur -> new ResponseEntity<>(utilisateur, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/utilisateur/list")
    @JsonView(UtilisateurView.class)
    public List<Utilisateur> list() {
        return utilisateurDao.findAll();
    }

    @PostMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public String add(@RequestBody Utilisateur newUtilisateur) {
        utilisateurDao.save(newUtilisateur);
        return "Utilisateur sauvegardé";
    }

    @DeleteMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> delete(@PathVariable int id) {
        if (utilisateurDao.existsById(id)) {
            utilisateurDao.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
