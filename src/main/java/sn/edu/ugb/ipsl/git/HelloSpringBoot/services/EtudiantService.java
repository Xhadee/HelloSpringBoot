package sn.edu.ugb.ipsl.git.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.DepartementRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private DepartementRepository departementRepository;

    public List<Etudiant> getEtudiants() {
        return etudiantRepository.getAllEtudiants();
    }
    public Etudiant getEtudiantById(Integer id) {return etudiantRepository.getEtudiantById(id);}
    public void save(Etudiant etudiant) {
        etudiantRepository.saveEtudiant(etudiant);
    }
    public void delete(Etudiant etudiant) {
        etudiantRepository.deleteEtudiant(etudiant);
    }
    /*recherche*/
    public List<Etudiant> searchEtudiant (String txt) {
        String like = "%"+txt+"%";
        return departementRepository.searchEtudiant(like);
    }
}
