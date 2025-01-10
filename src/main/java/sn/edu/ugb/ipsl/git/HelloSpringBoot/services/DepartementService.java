package sn.edu.ugb.ipsl.git.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.DepartementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }
    public Optional<Departement> getDepartementByCode(String code) {
      /*Optional<Departement> res = departementRepository.findById(code);
      return res;*/
        return departementRepository.findById(code);

    }


}
