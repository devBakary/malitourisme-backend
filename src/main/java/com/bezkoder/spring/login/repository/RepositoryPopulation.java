package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPopulation extends JpaRepository<Population, Long> {

}
