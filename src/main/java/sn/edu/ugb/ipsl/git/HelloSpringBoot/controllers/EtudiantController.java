package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.services.EtudiantService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping   /*avec une requete de type Get, voila ce qui est executé*/
    public List<Etudiant> getEtudiants() {
        return etudiantService.getEtudiants();
    }

    @GetMapping("/{id}")
    public ResponseEntity getEtudiantById(@PathVariable Integer id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etudiant);
    }

    @PutMapping
    public ResponseEntity saveEtudiant(@RequestBody Etudiant etudiant) {
        if (etudiant.getPrenom() == null)  {
            return ResponseEntity.status(450).body("Prenom obligatoire");
        }
        if (etudiant.getPrenom().isBlank())  {
            return ResponseEntity.status(451).body("Prenom ne doit pas etre vide");
        }
        if (etudiant.getNom() == null) {
            return ResponseEntity.status(455).body("Nom obligatoire");
        }
        if (etudiant.getNom().isBlank())  {
            return ResponseEntity.status(456).body("nom ne doit pas etre vide");
        }

        etudiantService.save(etudiant);
        return ResponseEntity.status(201).body(etudiant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEtudiant(@PathVariable Integer id){
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            return ResponseEntity.status(404).body("Etudiant dont l'id est " +id+ "n' existe pas");
        }
        etudiantService.delete(etudiant);
        return ResponseEntity.status(200).build();
    }

}
