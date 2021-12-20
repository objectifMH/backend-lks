/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller.api;

import static com.lks.backendtechnicaltest.config.Constante.APP_ROOT;
import com.lks.backendtechnicaltest.entity.Actor;
//import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author omh
 */

//@Api(APP_ROOT + "actors")
public interface ActorApi {
    
    @GetMapping(value = APP_ROOT + "actors")
    ResponseEntity<List<Actor>> findAll();
    
    @PostMapping(value = APP_ROOT + "actors")
    ResponseEntity<Actor> save(@RequestBody Actor actor);
    
    @GetMapping(value = APP_ROOT + "actors/{id}")
    ResponseEntity<Actor> findById(@PathVariable Integer id);
    
    @GetMapping(value = APP_ROOT + "actors/name/{name}")
    ResponseEntity<Actor> findByName(@PathVariable String name);
    
    @GetMapping(value = APP_ROOT + "actors/searchActors/{name}")
    ResponseEntity<List<Actor>> findActorsByName(@PathVariable String nameActor);
    
    @DeleteMapping(value = APP_ROOT + "actors/{id}")
    ResponseEntity deleteById(@PathVariable Integer idActor);
    
    
}
