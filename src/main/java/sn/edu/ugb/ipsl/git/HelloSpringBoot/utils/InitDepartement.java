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
        Departement d1 = new Departement();
        d1.setNom("Genie Informatique");
        d1.setCode("GIT");
        departementRepository.save(d1);

        Departement d2 = new Departement();
        d2.setNom("Genie Electromecanique");
        d2.setCode("GEM");
        departementRepository.save(d2);

        Departement d3 = new Departement();
        d3.setNom("Genie civil");
        d3.setCode("GEC");
        departementRepository.save(d3);
    }

}
