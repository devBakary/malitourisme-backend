package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.Population;

import java.util.List;

public interface ServicePopulation {

    Population creer(Population population);

    List<Population> afficher();

    Population modifier(Long id_Population, Population population);

    String supprimer(Long id_Population);
}
