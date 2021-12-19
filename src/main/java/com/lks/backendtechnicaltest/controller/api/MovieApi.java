/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller.api;

import static com.lks.backendtechnicaltest.config.Constante.APP_ROOT;
import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Movie;
import io.swagger.annotations.Api;
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
@Api(APP_ROOT + "movies")
public interface MovieApi {

    @GetMapping(value = APP_ROOT + "movies")
    ResponseEntity<List<Movie>> findAll();

    @PostMapping(value = APP_ROOT + "movies")
    ResponseEntity<Movie> save(@RequestBody Movie movie);

    @GetMapping(value = APP_ROOT + "movies/{id}")
    ResponseEntity<Movie> findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/title/{title}")
    ResponseEntity<Movie> findByTitle(@PathVariable String title);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/{title}")
    ResponseEntity<List<Movie>> findMoviesByTitle(@PathVariable String title);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/director/{id}")
    ResponseEntity<List<Movie>> findMoviesByDirector(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/actor/{id}")
    ResponseEntity<List<Movie>> findMoviesByActor(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/searchActors/{id}")
    ResponseEntity<List<Actor>> findActorsForMovieById(@PathVariable Integer id);

    @DeleteMapping(value = APP_ROOT + "movies/{id}")
    ResponseEntity deleteById(@PathVariable Integer id);

}
