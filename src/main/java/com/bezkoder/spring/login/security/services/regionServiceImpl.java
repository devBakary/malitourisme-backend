package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.region;
import com.bezkoder.spring.login.repository.repositoryRegion;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class regionServiceImpl implements serviceRegion{


    @Autowired
    repositoryRegion repositoryRegion;

    @ApiOperation(value = "Ajout des region")
    @Override
    public region creer(region region) {
        return repositoryRegion.save(region);
    }

    @ApiOperation(value = "liste des regions")
    @Override
    public List<region> afficher() {
        return repositoryRegion.findAll();
    }

    @ApiOperation(value = "Modification dans la region")
    @Override
    public region modifier(Long id_region, region region) {
        return repositoryRegion.findById(id_region).
                map(r->{
                    r.setCode_region(region.getCode_region());
                    r.setNom_region(region.getNom_region());
                    r.setDomaine_activite(region.getDomaine_activite());
                    r.setLangue_parler(region.getLangue_parler());
                    r.setSuperficie(region.getSuperficie());
                    return repositoryRegion.save(r);
                }).orElseThrow(()-> new RuntimeException("region non trouvé !"));
    }

    @ApiOperation(value = "suppression de la population")
    @Override
    public String supprimer(Long id_region) {
        repositoryRegion.deleteById(id_region);
        return "region supprimé";
    }
}
