/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller;

import com.lks.backendtechnicaltest.controller.api.DirectorApi;
import com.lks.backendtechnicaltest.entity.Director;
import com.lks.backendtechnicaltest.service.DirectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omh
 */
@RestController
public class DirectorController implements DirectorApi {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    //public ResponseEntity<List<Director>> findAll() {
    public List<Director> findAll() {
        return directorService.findAll();
    }

    @Override
    public ResponseEntity<Director> save(Director director) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.save(director));
    }

    @Override
    public ResponseEntity<Director> findById(Integer id) {
        return ResponseEntity.ok(directorService.findById(id));
    }

    @Override
    public ResponseEntity<Director> findByName(String name) {
        return ResponseEntity.ok(directorService.findByName(name));
    }

    @Override
    public ResponseEntity<List<Director>> findDirectorByName(String name) {
        return ResponseEntity.ok(directorService.findDirectorsByName(name));
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        directorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
