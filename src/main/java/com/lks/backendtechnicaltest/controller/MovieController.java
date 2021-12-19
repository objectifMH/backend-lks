/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller;

import com.lks.backendtechnicaltest.controller.api.MovieApi;
import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Movie;
import com.lks.backendtechnicaltest.service.MovieService;
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
public class MovieController implements MovieApi {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @Override
    public ResponseEntity<Movie> save(Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @Override
    public ResponseEntity<Movie> findById(Integer id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @Override
    public ResponseEntity<Movie> findByTitle(String title) {
        return ResponseEntity.ok(movieService.findByTitle(title));
    }

    @Override
    public ResponseEntity<List<Movie>> findMoviesByTitle(String title) {
        return ResponseEntity.ok(movieService.findMoviesByTitle(title));
    }

    @Override
    public ResponseEntity<List<Movie>> findMoviesByDirector(Integer id) {
        return ResponseEntity.ok(movieService.findMoviesByDirector(id));
    }

    @Override
    public ResponseEntity<List<Movie>> findMoviesByActor(Integer id) {
        return ResponseEntity.ok(movieService.findMoviesByActor(id));
    }

    @Override
    public ResponseEntity<List<Actor>> findActorsForMovieById(Integer id) {
        return ResponseEntity.ok(movieService.findActorsForMovieById(id));
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
