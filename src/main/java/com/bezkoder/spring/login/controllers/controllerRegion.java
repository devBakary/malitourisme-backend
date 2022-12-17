package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.region;
import com.bezkoder.spring.login.security.services.serviceRegion;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourisme/region")
@Data
@Api(value = "hello", description = "Mon API de gestion de site de Tourisme au Mali")
public class controllerRegion {

    @Autowired
    com.bezkoder.spring.login.security.services.serviceRegion serviceRegion;




    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public region create(@RequestBody region region){
        return serviceRegion.creer(region);
    }


    @GetMapping("/read")
    public List<region> read(){
        return serviceRegion.afficher();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public region update(@PathVariable Long id_region, @RequestBody region region){
        return serviceRegion.modifier(id_region,  region);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id_region){
        return serviceRegion.supprimer(id_region);
    }

}
