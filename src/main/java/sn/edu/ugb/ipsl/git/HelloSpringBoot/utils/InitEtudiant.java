package sn.edu.ugb.ipsl.git.HelloSpringBoot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.EtudiantRepository;

@Component
public class InitEtudiant implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("###Initialisation etudiant");
        Etudiant e1 = new Etudiant();
        e1.setPrenom("Xhadee");
        e1.setNom("JAAY");


        Etudiant e2 = Etudiant.builder()
                .prenom("Seydou")
                .nom("banana")
                .build();
        etudiantRepository.saveEtudiant(e2);

        etudiantRepository.saveEtudiant(e1);
    }
}
