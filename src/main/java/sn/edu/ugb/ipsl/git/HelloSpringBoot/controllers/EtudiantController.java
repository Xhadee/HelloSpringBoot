package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springdoc.core.fn.builders.content.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.services.DepartementService;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.services.EtudiantService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Operation(
            summary = "Liste des etudiants",
            description = "retourne l'ensemble des etudiants de l'IPSL"

    )
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

    @GetMapping("/search")
    public ResponseEntity<List<Etudiant>> searchEtudiants(@RequestParam String txt) {
        List<Etudiant> etudiants= etudiantService.searchEtudiant(txt);
        return ResponseEntity.ok().body(etudiants);
    }

    @PutMapping
    @Operation(
            summary = "enregistre un etudiant",
            description = "permet d'enregistrer l'etudiant mais on ne met pas l'id car il est genere automatiquement par le systeme",
            responses = {
                    @ApiResponse(
                            responseCode = "450",
                            description = "absence de l'attribut prenom dans l'objet json de la requete",
                            content = @Content(
                                    examples = {
                                            @ExampleObject(
                                                    description = "reponse en cas d'absence de la balise prenom",
                                                    value = "Prenom obligatoire"
                                            ),
                                            @ExampleObject(
                                                    description = "la balise prenom est presente mais elle est vide",
                                                    value = "Prenom ne doit pas etre vide"
                                            )
                                    }
                            )
                    )


            }
    )
    public ResponseEntity saveEtudiant(
            @RequestBody
            @Parameter(
                    description = "l'etudiant à enregistrer,il ne faut pas mettre l'attribut id "
            )
            Etudiant etudiant

    ) {
        if (etudiant.getPrenom() == null)  {
            return ResponseEntity.status(450).body("Prenom obligatoire");
        }
        if (etudiant.getPrenom().isBlank())  {
            return ResponseEntity.status(450).body("Prenom ne doit pas etre vide");
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
