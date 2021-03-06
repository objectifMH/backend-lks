/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service.Implementation;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.repository.ActorRepository;
import com.lks.backendtechnicaltest.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lks.backendtechnicaltest.service.ActorService;

/**
 *
 * @author omh
 */
@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor findById(Integer id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor", "id", id));
        return actor;

    }

    @Override
    public void deleteById(Integer id) {
        if (!actorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Actor", "id", id);
        }
        actorRepository.deleteById(id);
    }

    @Override
    public Actor findByName(String name) {
        return actorRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ResourceNotFoundException("Actor", "name", name));
    }

    @Override
    public List<Actor> findActorsByName(String name) {
        System.out.println(actorRepository.findByNameContainingIgnoreCase(name).size());
        return actorRepository.findByNameContainingIgnoreCase(name);
    }

}
