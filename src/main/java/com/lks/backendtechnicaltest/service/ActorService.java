/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service;

import com.lks.backendtechnicaltest.entity.Actor;
import java.util.List;

/**
 *
 * @author omh
 */
public interface ActorService {
    
    List<Actor> findAll();
    
    Actor save(Actor actor);
    
    Actor findById(Integer id);
    
    Actor findByName(String name);
    
    List<Actor> findActorsByName(String name);
    
    void deleteById(Integer id);
    
    
    
    
    
}
