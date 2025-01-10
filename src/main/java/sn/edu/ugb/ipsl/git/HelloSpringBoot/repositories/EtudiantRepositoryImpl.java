package sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Etudiant;

import java.util.List;

@Repository
public class EtudiantRepositoryImpl implements EtudiantRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void saveEtudiant(Etudiant etudiant) {
        if (etudiant.getId() == null) {
            em.persist(etudiant);
        }
        else {
            em.merge(etudiant);
        }

    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return em.find(Etudiant.class, id);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        String jpql = "SELECT e FROM Etudiant e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteEtudiant(Etudiant etudiant) {
        em.remove(etudiant);
    }
}
