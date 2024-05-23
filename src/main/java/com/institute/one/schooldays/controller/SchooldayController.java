package com.institute.one.schooldays.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.institute.one.schooldays.dto.SchooldayDTO;
import com.institute.one.schooldays.service.interfaces.ISchooldayService;
import com.institute.one.subject.dto.SubjectDTO;
import com.institute.one.subject.service.interfaces.ISubjectService;
import com.institute.one.utilities.enums.StateEnum;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/jornadas")
@PreAuthorize("denyAll()")
public class SchooldayController {

    @Autowired
    private ISchooldayService schooldayService;

    // find all
    @GetMapping("/ver")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<SchooldayDTO>> findAll() {

        return new ResponseEntity<>(this.schooldayService.findAll(), HttpStatus.OK);

    }

    // find by id
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/ver/{id}")
    public ResponseEntity<SchooldayDTO> findById(@PathVariable Long id) {

        return new ResponseEntity<>(this.schooldayService.findById(id), HttpStatus.OK);

    }

    // find by nameContaining
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/buscar/nombre/{name}")
    public ResponseEntity<List<SchooldayDTO>> findAllByNameContaining(@PathVariable String name) {

        return new ResponseEntity<>(this.schooldayService.findAllByNameContaining(name), HttpStatus.OK);

    }

    // findAllByDescriptionContaining
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/buscar/descripcion/{description}")
    public ResponseEntity<List<SchooldayDTO>> findAllByDescriptionContaining(@PathVariable String description) {

        return new ResponseEntity<>(this.schooldayService.findAllByDescriptionContaining(description),
                HttpStatus.OK);

    }

    // // find by state
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/buscar/estado/{state}")
    public ResponseEntity<List<SchooldayDTO>> findByState(@PathVariable String state) {

        StateEnum[] states = StateEnum.values();
        for (StateEnum state1 : states) {
            if (state1.name().equals(state)) {

                StateEnum stateEnum = StateEnum.valueOf(state);

                return new ResponseEntity<>(this.schooldayService.findByState(stateEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // create user
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<SchooldayDTO> save(@Valid @RequestBody SchooldayDTO schooldayDTO) {

        return new ResponseEntity<>(this.schooldayService.save(schooldayDTO), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<SchooldayDTO> update(@RequestBody SchooldayDTO schooldayDTO, @PathVariable Long id) {

        return new ResponseEntity<>(this.schooldayService.update(id, schooldayDTO), HttpStatus.OK);

    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.schooldayService.delete(id), HttpStatus.NO_CONTENT);
    }

}
