package sn.edu.ugb.ipsl.git.HelloSpringBoot.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.DepartementRepository;

@Component
public class InitDepartement implements CommandLineRunner {
    @Autowired
    private DepartementRepository departementRepository;

    public void run(String... args) throws Exception {
        Departement departement = new Departement();
        departement.setNom("Informatique");
        departement.setCode("D1");
        departementRepository.save(departement);

    }

}
