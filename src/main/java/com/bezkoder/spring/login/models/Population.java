package com.bezkoder.spring.login.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String annee;
    private Integer habitants;



    @ManyToOne
    private region region;



}
