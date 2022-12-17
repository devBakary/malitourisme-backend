package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPays extends JpaRepository<pays, Long> {

}
