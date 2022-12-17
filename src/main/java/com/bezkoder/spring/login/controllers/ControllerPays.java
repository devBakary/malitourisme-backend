package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.pays;
import com.bezkoder.spring.login.security.services.servicePays;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/tourisme/pays")
@Api(value = "hello", description = "Mon API de de site de Tourisme au Mali")
public class ControllerPays {

    @Autowired
    com.bezkoder.spring.login.security.services.servicePays servicePays;



    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public pays create(@RequestBody pays pays){
        return servicePays.creer(pays);
    }

    @GetMapping("/read")
    public List<pays> read(){
        return servicePays.afficher();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public pays update(@PathVariable Long id, @RequestBody pays pays){
        return servicePays.modifier(id,  pays);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return servicePays.supprimer(id);
    }
}
