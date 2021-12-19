/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller;

import com.lks.backendtechnicaltest.controller.api.ActorApi;
import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.service.ActorService;
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
public class ActorController implements ActorApi {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public ResponseEntity<List<Actor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findAll());
    }

    @Override
    public ResponseEntity<Actor> save(Actor actor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.save(actor));
    }

    @Override
    public ResponseEntity<Actor> findById(Integer id) {
        return ResponseEntity.ok(actorService.findById(id));
    }

    @Override
    public ResponseEntity<Actor> findByName(String name) {
        return ResponseEntity.ok(actorService.findByName(name));
    }

    @Override
    public ResponseEntity<List<Actor>> findActorsByName(String name) {
        return ResponseEntity.ok(actorService.findActorsByName(name));
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        actorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
