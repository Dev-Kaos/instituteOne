package com.institute.one.schooldays.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.one.schooldays.dto.SchooldayDTO;
import com.institute.one.schooldays.persistence.model.SchooldayEntity;
import com.institute.one.schooldays.persistence.repository.ISchooldayRepository;
import com.institute.one.schooldays.service.interfaces.ISchooldayService;
import com.institute.one.subject.dto.SubjectDTO;
import com.institute.one.subject.persistence.model.SubjectEntity;
import com.institute.one.utilities.enums.StateEnum;

@Service
public class SchooldayServiceImp implements ISchooldayService {

    @Autowired
    private ISchooldayRepository schooldayRepository;

    @Override
    public List<SchooldayDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();
        return this.schooldayRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, SchooldayDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public SchooldayDTO findById(Long id) {

        Optional<SchooldayEntity> schooldayEntity = this.schooldayRepository.findById(id);

        if (schooldayEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            SchooldayEntity currentSchoolday = schooldayEntity.get();

            return modelMapper.map(currentSchoolday, SchooldayDTO.class);

        } else {

            return new SchooldayDTO();

        }
    }

    @Override
    public List<SchooldayDTO> findAllByNameContaining(String name) {

        ModelMapper modelMapper = new ModelMapper();
        return this.schooldayRepository.findAllByNameContaining(name)
                .stream()
                .map(entity -> modelMapper.map(entity, SchooldayDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<SchooldayDTO> findAllByDescriptionContaining(String description)
    {
    ModelMapper modelMapper = new ModelMapper();
    return this.schooldayRepository.findAllByDescriptionContaining(description)
    .stream()
    .map(entity -> modelMapper.map(entity, SchooldayDTO.class))
    .collect(Collectors.toList());
    }

    // @Override
    // public List<SchooldayDTO> findAllByStateContaining(String state) {

    // ModelMapper modelMapper = new ModelMapper();
    // return this.schooldayRepository.findAllByStateContaining(state)
    // .stream()
    // .map(entity -> modelMapper.map(entity, SchooldayDTO.class))
    // .collect(Collectors.toList());
    // }

    @Override
    public SchooldayDTO save(SchooldayDTO schooldayDTO) {

        try {

            ModelMapper modelMapper = new ModelMapper();
            SchooldayEntity schooldayEntity = modelMapper.map(schooldayDTO, SchooldayEntity.class);
            this.schooldayRepository.save(schooldayEntity);
            return schooldayDTO;

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar la jornada");
        }
    }

    @Override
    public SchooldayDTO update(Long id, SchooldayDTO schooldayDTO) {

        Optional<SchooldayEntity> schooldayEntity = this.schooldayRepository.findById(id);

        if (schooldayEntity.isPresent()) {

            SchooldayEntity currentSchooldayEntity = schooldayEntity.get();
            currentSchooldayEntity.setName(schooldayDTO.getName());
            currentSchooldayEntity.setDescription(schooldayDTO.getDescription());
            currentSchooldayEntity.setState(schooldayDTO.getState());
            this.schooldayRepository.save(currentSchooldayEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentSchooldayEntity, SchooldayDTO.class);

        } else {

            throw new IllegalArgumentException("La jornada que se quiere actualizar no existe");

        }
    }

    @Override
    public String delete(Long id) {

        Optional<SchooldayEntity> schooldayEntity = this.schooldayRepository.findById(id);

        if (schooldayEntity.isPresent()) {

            SchooldayEntity currentSchooldayEntity = schooldayEntity.get();

            this.schooldayRepository.delete(currentSchooldayEntity);

            return "la jornada con " + id + " ha sido eliminada";

        } else {
            return "la jornada con " + id + " no existe";
        }
    }

    @Override
    public List<SchooldayDTO> findByState(StateEnum stateEnum) {

        ModelMapper modelMapper = new ModelMapper();
    return this.schooldayRepository.findByState(stateEnum)
    .stream()
    .map(entity -> modelMapper.map(entity, SchooldayDTO.class))
    .collect(Collectors.toList());

    }

}
