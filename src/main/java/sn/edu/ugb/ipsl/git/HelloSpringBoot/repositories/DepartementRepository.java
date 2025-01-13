package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, String> {

    Optional <Departement> findByNom(String nom);

    List<Departement> findByNomContainingOrCodeContaining(String nom, String code);

    //@Query("select e from Etudiant e where e.nom like :txt or e.prenom like :txt or e.filiere.nom like :txt")
    @Query("select e from Etudiant e where e.nom like :txt or e.prenom like :txt order by e.nom,e.prenom desc")
    //@Query("select e from Etudiant e where e.nom like :txt or e.prenom like :txt order by e.nom,e.prenom")
    List<Etudiant> searchEtudiant(String txt);




}
