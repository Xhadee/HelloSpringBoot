package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @GetMapping   /*avec une requete de type Get, voila ce qui est executé*/
    public List<Etudiant> getEtudiants() {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        for (int i = 0; i < 10; i++) {
            Etudiant etudiant = new Etudiant();
            etudiant.setPrenom("prenom"+i);
            etudiant.setNom("nom"+i);
            etudiant.setAdresse("adresse"+i);
            etudiants.add(etudiant);
        }
        return etudiants;
    }

}
