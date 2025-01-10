package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, String> {




}
