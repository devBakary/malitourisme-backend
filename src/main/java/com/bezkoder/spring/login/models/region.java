package com.bezkoder.spring.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_region;
    @Column(name = "code_region", unique = true)
    private String code_region;
    @Column(unique = true)
    private String nom_region;

    private String domaine_activite;

    private String langue_parler;
    private String superficie;
    private String description;


    @ManyToOne
    private pays pays;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<Population> population;



}
