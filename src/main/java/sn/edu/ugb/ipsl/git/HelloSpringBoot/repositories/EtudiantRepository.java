package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import java.util.List;

public interface EtudiantRepository {
    void saveEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(Integer id);
    List<Etudiant> getAllEtudiants();

}
