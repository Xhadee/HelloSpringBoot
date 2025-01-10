package sn.edu.ugb.ipsl.git.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    public List<Etudiant> getEtudiants() {
        return etudiantRepository.getAllEtudiants();
    }
}
