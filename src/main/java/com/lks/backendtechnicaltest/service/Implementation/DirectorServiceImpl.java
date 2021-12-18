/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service.Implementation;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Director;
import com.lks.backendtechnicaltest.exception.EntityNotFound;
import com.lks.backendtechnicaltest.exception.ResourceNotFoundException;
import com.lks.backendtechnicaltest.repository.ActorRepository;
import com.lks.backendtechnicaltest.repository.DirectorRepository;
import com.lks.backendtechnicaltest.service.DirectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omh
 */
@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director save(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director findById(Integer id) {
        return directorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Director with id : " + id + ", is not found !"));
    }

    @Override
    public void deleteById(Integer id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Director with id : " + id + ", is not found !"));
        directorRepository.deleteById(id);
        System.out.println("Director with id : " + id + ", is deleted !");
    }

    @Override
    public Director findByName(String name) {
        return directorRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFound("Director with name : " + name + ", is not found !"));

    }

    @Override
    public List<Director> findDirectorsByName(String name) {
        System.out.println(directorRepository.findByNameContainingIgnoreCase(name).size());
        return directorRepository.findByNameContainingIgnoreCase(name);
    }

}
