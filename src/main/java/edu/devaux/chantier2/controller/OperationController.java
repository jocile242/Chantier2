package edu.devaux.chantier2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.chantier2.dao.OperationDao;
import edu.devaux.chantier2.model.Operation;
import edu.devaux.chantier2.view.OperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.List;


@RestController
public class OperationController {

    OperationDao operationDao;

    @Autowired
    public OperationController(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    @GetMapping("/operation/{id}")
    @JsonView(OperationView.class)
    public ResponseEntity<Operation> get(@PathVariable int id) {

        Optional<Operation> operationOptional = operationDao.findById(id);

        if (operationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(operationOptional.get(), HttpStatus.OK);

    }

    @GetMapping("/operation/list")
    @JsonView(OperationView.class)
    public List<Operation> list() {
        return operationDao.findAll();
    }

    @PostMapping("/operation")
    @JsonView(OperationView.class)
    public String add(@RequestBody Operation newOperation) {
        this.operationDao.save(newOperation);
        return "Utilisateur sauvegardé";
    }


    @DeleteMapping("/operation/{id}")
    @JsonView(OperationView.class)
    public ResponseEntity<Operation> delete(@PathVariable int id) {
        Optional<Operation> operationToDelete = operationDao.findById(id);
        if (operationToDelete.isPresent()) {
            operationDao.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}