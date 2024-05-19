package com.institute.one.subject.persistence.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.institute.one.subject.persistence.model.SubjectEntity;

public interface ISubjectDAO {

    List<SubjectEntity> findAll();

    Optional<SubjectEntity>findById(Long id);

    void saveSubject(SubjectEntity subjectEntity);

    void updateSubject(SubjectEntity subjectEntity);

    void deleteSubject(SubjectEntity subjectEntity);

}
