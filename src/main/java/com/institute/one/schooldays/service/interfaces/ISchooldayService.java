package com.institute.one.schooldays.service.interfaces;

import java.util.List;

import com.institute.one.schooldays.dto.SchooldayDTO;
import com.institute.one.utilities.enums.StateEnum;

public interface ISchooldayService {

    List<SchooldayDTO> findAll();

    SchooldayDTO findById(Long id);
    
    List<SchooldayDTO> findAllByNameContaining(String name);

    List<SchooldayDTO> findAllByDescriptionContaining(String description);

    List<SchooldayDTO> findByState(StateEnum stateEnum);

    // List<SchooldayDTO> findAllByStateContaining(String state);

    SchooldayDTO save(SchooldayDTO schooldayDTO);

    SchooldayDTO update(Long id, SchooldayDTO schooldayDTO);

    String delete(Long id);


}
