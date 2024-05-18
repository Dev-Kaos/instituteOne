package com.institute.one.subject.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.institute.one.subject.dto.SubjectDTO;
import com.institute.one.subject.service.interfaces.ISubjectService;

@Service
public class SubjectServiceImp implements ISubjectService    {

    @Override
    public List<SubjectDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public SubjectDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSubject'");
    }

    @Override
    public SubjectDTO updateSubject(Long id, SubjectDTO subjectDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSubject'");
    }

    @Override
    public String deleteSubject(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSubject'");
    }

}
