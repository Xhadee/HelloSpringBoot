package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, String> {

}
