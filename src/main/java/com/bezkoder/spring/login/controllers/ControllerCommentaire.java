package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Commentaire;
import com.bezkoder.spring.login.security.services.commentaireServ;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tourisme/commentaire")
@AllArgsConstructor
public class ControllerCommentaire {

    @Autowired
    private commentaireServ service;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/ajouter")
    public Commentaire creer(@RequestBody Commentaire commentaire) {
        return service.creer(commentaire);
    }

    @GetMapping("/afficher")
    public List<Commentaire> afficher() {
        return service.liste();
    }
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/modifier/{id}")
    public Commentaire modifier(@RequestBody Commentaire commentaire, @PathVariable Long id) {
        return service.modifier(commentaire, id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){

        service.supprimer(id);
        return "effacer avec success";
    }
}
