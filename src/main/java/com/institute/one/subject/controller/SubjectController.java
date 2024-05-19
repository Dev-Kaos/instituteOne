package com.institute.one.subject.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.institute.one.subject.dto.SubjectDTO;
import com.institute.one.subject.service.interfaces.ISubjectService;

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
@RequestMapping("/materia")
@PreAuthorize("denyAll()")
public class SubjectController {
    
    @Autowired
    private ISubjectService subjectService;
    
    // find all
    @GetMapping("/find")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<SubjectDTO>> findAll() {
        
        return new ResponseEntity<>(this.subjectService.findAll(), HttpStatus.OK);
        
    }
    
    // find by id
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/find/{id}")
    public ResponseEntity<SubjectDTO> findById(@PathVariable Long id) {
        
        return new ResponseEntity<>(this.subjectService.findById(id), HttpStatus.OK);
        
    }
    
    // create user
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {

        return new ResponseEntity<>(this.subjectService.createSubject(subjectDTO), HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO, @PathVariable Long id) {
        
        return new ResponseEntity<>(this.subjectService.updateSubject(id, subjectDTO), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {
        return new ResponseEntity<>(this.subjectService.deleteSubject(id), HttpStatus.NO_CONTENT);
    }

    // @PatchMapping("/patch")
    // // @PreAuthorize("hasAuthority('PATCH')")
    // public String helloPatch() {
    // return "funciona PATCH";
    // }

}
