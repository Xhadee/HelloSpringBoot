package sn.edu.ugb.ipsl.git.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.DepartementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    /*Departement par code*/
    public Optional<Departement> getDepartementByCode(String code) {
        return departementRepository.findById(code);
    }
    /*Liste Departement */
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }
    /*C ou MAJ*/
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
    /*Supp*/
    public void deleteDepartement(Departement departement) {
        departementRepository.delete(departement);
    }


}
