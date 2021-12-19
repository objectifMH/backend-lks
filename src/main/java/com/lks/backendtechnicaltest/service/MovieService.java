/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Movie;
import java.util.List;

/**
 *
 * @author omh
 */
public interface MovieService {

    List<Movie> findAll();

    Movie save(Movie movie);

    Movie findById(Integer id);

    Movie findByTitle(String title);

    List<Movie> findMoviesByTitle(String title);
    
    List<Movie> findMoviesByDirector(Integer id);
    
    List<Movie> findMoviesByActor(Integer id);
    
    List<Actor> findActorsForMovieById(Integer id);

    void deleteById(Integer id);
}
