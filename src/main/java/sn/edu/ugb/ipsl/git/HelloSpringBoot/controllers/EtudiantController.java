package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
