package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Commentaire;

import java.util.List;

public interface commentaireServ {

    Commentaire creer(Commentaire commentaire);

    Commentaire modifier(Commentaire commentaire, Long id);

    List<Commentaire> liste();

    void supprimer(Long id);
}
