package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Commentaire;
import com.bezkoder.spring.login.repository.RepositoryCommentaire;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentaireServImplemente implements commentaireServ{

    @Autowired
    private RepositoryCommentaire repo;


    @Override
    public Commentaire creer(Commentaire commentaire) {
        return repo.save(commentaire);
    }

    @Override
    public Commentaire modifier(Commentaire commentaire, Long id) {
        return null;
    }

    @Override
    public List<Commentaire> liste() {
        return repo.findAll();
    }

    @Override
    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}
