package com.institute.one.subject.service.interfaces;

import java.util.List;

import com.institute.one.subject.dto.SubjectDTO;

public interface ISubjectService {

    List<SubjectDTO> findAll();

    SubjectDTO findById(Long id);
    
    SubjectDTO createSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject(Long id, SubjectDTO subjectDTO);
    
    String deleteSubject(Long id);


}
