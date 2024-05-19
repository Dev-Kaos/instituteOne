package com.institute.one.subject.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.one.subject.dto.SubjectDTO;
import com.institute.one.subject.persistence.dao.interfaces.ISubjectDAO;
import com.institute.one.subject.persistence.model.SubjectEntity;
import com.institute.one.subject.service.interfaces.ISubjectService;

@Service
public class SubjectServiceImp implements ISubjectService {

    @Autowired
    private ISubjectDAO subjectDAO;

    @Override
    public List<SubjectDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.subjectDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, SubjectDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public SubjectDTO findById(Long id) {

        Optional<SubjectEntity> subjectEntity = this.subjectDAO.findById(id);

        if (subjectEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            SubjectEntity currentSubject = subjectEntity.get();

            return modelMapper.map(currentSubject, SubjectDTO.class);

        } else {

            return new SubjectDTO();

        }

    }

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {

        try {
            
            ModelMapper modelMapper = new ModelMapper();
            SubjectEntity subjectEntity= modelMapper.map(subjectDTO, SubjectEntity.class);
            this.subjectDAO.saveSubject(subjectEntity);
            return subjectDTO;

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
        
    }

    @Override
    public SubjectDTO updateSubject(Long id, SubjectDTO subjectDTO) {
        
        
        Optional<SubjectEntity> subjectEntity = this.subjectDAO.findById(id);

        if (subjectEntity.isPresent()) {

            SubjectEntity currentSubjectEntity = subjectEntity.get();
            currentSubjectEntity.setName(subjectDTO.getName());
            this.subjectDAO.updateSubject(currentSubjectEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentSubjectEntity, SubjectDTO.class);
            
        }else{
            throw new IllegalArgumentException("La materia no existe");
        }
        
        

    }

    @Override
    public String deleteSubject(Long id) {

        Optional<SubjectEntity> subjectEntity = this.subjectDAO.findById(id);

        if (subjectEntity.isPresent()) {

            SubjectEntity currentSubjectEntity = subjectEntity.get();

            this.subjectDAO.deleteSubject(currentSubjectEntity);

            return "La Materia con el" + id +"ha sido eliminada";
            
        }
        else{
            return "La Materia con el" + id +"no existe";
        }
        
    }

}
