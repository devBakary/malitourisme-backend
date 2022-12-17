package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.Population;
import com.bezkoder.spring.login.repository.RepositoryPopulation;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements ServicePopulation {

    @Autowired
    private com.bezkoder.spring.login.repository.RepositoryPopulation RepositoryPopulation;

    @ApiOperation(value = "Ajout de la population")
    @Override
    public Population creer(Population population) {
        return RepositoryPopulation.save(population);
    }

    @ApiOperation(value = "Liste dans la population")
    @Override
    public List<Population> afficher() {
        return RepositoryPopulation.findAll();
    }



    @ApiOperation(value = "Modification dans la population")
    @Override
    public Population modifier(Long id_Population, Population population) {
        return   RepositoryPopulation.findById(id_Population).
                map(pp->{
                    pp.setId(population.getId());
                    pp.setAnnee(population.getAnnee());
                    pp.setHabitants(population.getHabitants());
                    return RepositoryPopulation.save(pp);
                }).orElseThrow(()-> new RuntimeException("pas de population trouvé !"));
    }

    @ApiOperation(value = "Mon API de gestion de Tourisme")
    @Override
    public String supprimer(Long id_Population) {
        RepositoryPopulation.deleteById(id_Population);
        return "population supprimé";
    }
}
