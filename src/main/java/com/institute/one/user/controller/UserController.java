package com.institute.one.user.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/usuario")
@PreAuthorize("denyAll()")
public class UserController {
    
    @GetMapping("/funciona")
    @PreAuthorize("permitAll()")
    public String funciona() {
        return "funciona";
    }
    
    @GetMapping("/seguridad")
    @PreAuthorize("hasAuthority('CREATE')")
    public String seguridad() {
        return "seguridad";
    }

}
