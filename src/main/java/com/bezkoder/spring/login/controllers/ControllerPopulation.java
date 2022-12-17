package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Population;
import com.bezkoder.spring.login.security.services.ServicePopulation;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/tourisme/population")
@Api(value = "hello", description = "Mon API de gestion de Tourisme au MAli")
public class ControllerPopulation {

    @Autowired
    com.bezkoder.spring.login.security.services.ServicePopulation ServicePopulation;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public Population create(@RequestBody Population population){
        return ServicePopulation.creer(population);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/read")
    public List<Population> read(){
        return ServicePopulation.afficher();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id_Population}")
    public Population update(@PathVariable Long id_Population, @RequestBody Population population){
        return ServicePopulation.modifier(id_Population,  population);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id_Population}")
    public String delete(@PathVariable Long id_Population){
        return ServicePopulation.supprimer(id_Population);
    }

}
