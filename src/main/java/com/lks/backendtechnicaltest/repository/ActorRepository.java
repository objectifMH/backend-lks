/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.repository;

import com.lks.backendtechnicaltest.entity.Actor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author omh
 */
public interface ActorRepository extends JpaRepository<Actor, Integer>{
    
    public Optional<Actor> findByNameIgnoreCase(String name);
    
    public List<Actor> findByNameContainingIgnoreCase(String name);
    
    //  Lister les acteurs d'un film
    @Query(value = "SELECT * FROM ACTOR a, ACTOR_MOVIE am WHERE a.id = am.actor_id and am.movie_id = ?1", nativeQuery = true)
    public List<Actor> findActorsForMovieById(Integer id);
     
}
