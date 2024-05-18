package com.institute.one.user.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/usuario")
// @PreAuthorize("denyAll()")
public class UserController {
    
    @GetMapping("/funciona")
    // @PreAuthorize("permitAll()")
    public String funciona() {
        return "funciona";
    }
    
    @GetMapping("/seguridad")
    // @PreAuthorize("hasAuthority('CREATE')")
    public String seguridad() {
        return "seguridad !=";
    }


    //TODO others

    @GetMapping("/get")
    // @PreAuthorize("hasAuthority('READ')")
    public String helloGet() {
        return "funciona GET";
    }
    
    @PostMapping("/post")
    // @PreAuthorize("hasAuthority('CREATE') or hasAuthority('READ')")
    public String helloPost() {
        return "funciona POST";
    }

    @PutMapping("/put")
    // @PreAuthorize("hasAuthority('UPDATE')")
    public String helloPut() {
        return "funciona PUT";
    }
    
    @DeleteMapping("/delete")
    // @PreAuthorize("hasAuthority('DELETE')")
    public String helloDelete() {
        return "funciona DELETE";
    }

    @PatchMapping("/patch")
    // @PreAuthorize("hasAuthority('PATCH')")
    public String helloPatch() {
        return "funciona PATCH";
    }

}
