package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Authentification;

import java.util.Optional;

public interface AuthentificationRepository extends JpaRepository<Authentification, Integer> {

    Optional<Authentification> findByToken(String token);
}