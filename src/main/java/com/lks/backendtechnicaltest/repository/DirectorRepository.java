/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.repository;

import com.lks.backendtechnicaltest.entity.Director;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author omh
 */

@CrossOrigin("*")
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    //Recherche une liste de directeur ayant le  mot clé name : 
    //Ex :    /directors/search/byName?nd=Nig
    @RestResource(path = "/byName")
    public Director findByName(String name);

    public Optional<Director> findByNameIgnoreCase(String name);
    
    public List<Director> findByNameContainingIgnoreCase(String name);
}
