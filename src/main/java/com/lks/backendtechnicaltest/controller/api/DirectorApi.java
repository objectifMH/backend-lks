/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller.api;

import static com.lks.backendtechnicaltest.config.Constante.APP_ROOT;
import com.lks.backendtechnicaltest.entity.Director;
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


public interface DirectorApi {
    
    @GetMapping(value = APP_ROOT + "directors")
    ResponseEntity<List<Director>> findAll();
    
    @PostMapping(value = APP_ROOT + "directors")
    ResponseEntity<Director> save(@RequestBody Director director);
    
    @GetMapping(value = APP_ROOT + "directors/{id}")
    ResponseEntity<Director> findById(@PathVariable Integer id);
    
    @GetMapping(value = APP_ROOT + "directors/name/{name}")
    ResponseEntity<Director> findByName(@PathVariable String name);
    
    @GetMapping(value = APP_ROOT + "directors/searchDirectors/{name}")
    ResponseEntity<List<Director>> findDirectorByName(@PathVariable String name);
    
    @DeleteMapping(value = APP_ROOT + "directors/{id}")
    ResponseEntity deleteById(@PathVariable Integer id);
    
    
}

