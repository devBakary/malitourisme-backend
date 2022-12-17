package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.pays;

import java.util.List;


public interface servicePays {

    pays creer(pays pays);

   List<pays> afficher();

    pays modifier(Long id, pays pays);

    String supprimer(Long id);
}
