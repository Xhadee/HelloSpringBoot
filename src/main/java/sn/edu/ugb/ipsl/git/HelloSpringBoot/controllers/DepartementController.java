package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.DepartementRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.services.DepartementService;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.services.EtudiantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;
    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }



    @GetMapping("/{code}")
    public ResponseEntity<Departement> getDepartementByCode(@PathVariable String code) {
        Optional<Departement> departement = departementService.getDepartementByCode(code);
        if (departement.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departement.get());
    }


    @PutMapping
    public ResponseEntity<String> saveDepartement(@RequestBody Departement departement) {
        try {
            if (departement.getNom() == null || departement.getNom().isBlank()) {
                return ResponseEntity.status(400).body("Le nom est obligatoire et ne peut pas être vide.");
            }

            if (departement.getCode() == null || departement.getCode().isBlank()) {
                return ResponseEntity.status(400).body("Le code est obligatoire et ne peut pas être vide.");
            }

            Optional<Departement> departementExistByCode = departementService.getDepartementByCode(departement.getCode());
            if (departementExistByCode.isPresent()) {
                return ResponseEntity.status(404).body("Département avec ce code non trouvé.");
            }
            departementService.saveDepartement(departement);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).body("Le nom du département est déjà pris.");
        }
    }


    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteDepartement(@PathVariable String code) {
        Optional<Departement> departement = departementService.getDepartementByCode(code);
        if (departement.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        departementService.deleteDepartement(departement.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" succès de la supp.");
    }

}