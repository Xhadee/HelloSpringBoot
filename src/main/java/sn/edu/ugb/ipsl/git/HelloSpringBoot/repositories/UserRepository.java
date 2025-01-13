package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmail(String email);
}