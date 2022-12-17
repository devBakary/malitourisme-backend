package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.pays;
import com.bezkoder.spring.login.repository.RepositoryPays;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements servicePays{


    @Autowired
    private final com.bezkoder.spring.login.repository.RepositoryPays RepositoryPays;

    @ApiOperation(value = "Ajout des pays")
    @Override
    public pays creer(pays pays) {
        return RepositoryPays.save(pays);
    }

    @Override
    public List<pays> afficher() {
        return RepositoryPays.findAll();
    }



    @ApiOperation(value = "Modification de pays")
    @Override
    public pays modifier(Long id, pays pays) {
        return RepositoryPays.findById(id).map(
                p->{
                    p.setId(pays.getId());
                    p.setNom(pays.getNom());
                    return RepositoryPays.save(p);
                }).orElseThrow(()-> new RuntimeException("pays non trouvé !")
        );
    }

    @ApiOperation(value = "suppression de pays")
    @Override
    public String supprimer(Long id) {
        RepositoryPays.deleteById(id);
        return "region supprimé";
    }
}
