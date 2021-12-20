/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.controller.api;

import static com.lks.backendtechnicaltest.config.Constante.APP_ROOT;
import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Movies Api", description = "Movies API with description tag annotation")
public interface MovieApi {

    @GetMapping(value = APP_ROOT + "movies")
    @Operation(summary = "Return all the movies in the bdd", description = "All the movies or a empty list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of all the movies or empty list.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})})
    ResponseEntity<List<Movie>> findAll();

    @PostMapping(value = APP_ROOT + "movies")
    @Operation(summary = "Create or update a movie", description = "Save a movie without an id or update an existing movie with its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "The movie has been created.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})})
    ResponseEntity< Movie> save(@RequestBody Movie movie);

    @GetMapping(value = APP_ROOT + "movies/{id}")
    @Operation(summary = "Find a movie", description = "Find a movie by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The movie has been found.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
        ,
        @ApiResponse(responseCode = "404", description = "The movie is not found.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
    })
    ResponseEntity<Movie> findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/title/{title}")
    @Operation(summary = "Find a movie", description = "Find a movie by its title")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The movie has been found.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
        ,
        @ApiResponse(responseCode = "404", description = "The movie with this title doesn't exist.")
    })
    ResponseEntity<Movie> findByTitle(@PathVariable String title);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/{title}")
    @Operation(summary = "Return all the movies filter by title", description = "All the movies filtered by title of the movie or a empty list")
    @ApiResponse(responseCode = "200", description = "List of all the movies or a empty list", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
    ResponseEntity<List<Movie>> findMoviesByTitle(@PathVariable String title);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/director/{id}")
    @Operation(summary = "Return all the movies made by a director", description = "All the movies filtered by id of the director or a empty list")
    @ApiResponse(responseCode = "200", description = "List of all the movies made by a director or a empty list")
    ResponseEntity<List<Movie>> findMoviesByDirector(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/searchMovies/actor/{id}")
    @Operation(summary = "Return all movies where an actor appears", description = "All the movies filtered by id of the actor or a empty list")
    @ApiResponse(responseCode = "200", description = "List of all the movies where an actor appeats or a empty list")
    ResponseEntity<List<Movie>> findMoviesByActor(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "movies/searchActors/{id}")
    @Operation(summary = "Return all actors for a movie", description = "All the actors filtered by id of the movie or a empty list")
    @ApiResponse(responseCode = "200", description = "List of all the actors in a movie or a empty list", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
    ResponseEntity<List<Actor>> findActorsForMovieById(@PathVariable Integer id);

    @Operation(summary = "Delete a movie", description = "Delete a movie by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The movie has been deleted.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
        ,
        @ApiResponse(responseCode = "404", description = "The movie is not found.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))})
    })
    @DeleteMapping(value = APP_ROOT + "movies/{id}")
    ResponseEntity deleteById(@PathVariable Integer id);

}
