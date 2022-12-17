package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.region;

import java.util.List;

public interface serviceRegion {

    region creer(region region);

    List<region> afficher();

    region modifier(Long id_region, region region);

    String supprimer(Long id_region);
}
