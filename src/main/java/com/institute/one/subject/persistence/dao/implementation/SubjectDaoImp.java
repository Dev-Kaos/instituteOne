package com.institute.one.subject.persistence.dao.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.institute.one.subject.persistence.dao.interfaces.ISubjectDAO;
import com.institute.one.subject.persistence.model.SubjectEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class SubjectDaoImp implements ISubjectDAO {

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public List<SubjectEntity> findAll() {
        
        return this.em.createQuery("SELECT u FROM SubjectEntity u").getResultList();                    
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<SubjectEntity> findById(Long id) {
        
        return Optional.ofNullable(this.em.find(SubjectEntity.class, id));
        
    }
    
    @Override
    @Transactional
    public void saveSubject(SubjectEntity subjectEntity) {
        
        this.em.persist(subjectEntity);
        this.em.flush();
        
    }
    
    @Override
    @Transactional
    public void updateSubject(SubjectEntity subjectEntity) {
        
        this.em.merge(subjectEntity);
        this.em.flush();
    }
    
    @Override
    @Transactional
    public void deleteSubject(SubjectEntity subjectEntity) {

        this.em.remove(subjectEntity);
        this.em.flush();
    }

}
