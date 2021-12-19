/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service.Implementation;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Movie;
import com.lks.backendtechnicaltest.exception.ResourceNotFoundException;
import com.lks.backendtechnicaltest.repository.ActorRepository;
import com.lks.backendtechnicaltest.repository.MovieRepository;
import com.lks.backendtechnicaltest.service.MovieService;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omh
 */
@Service
@Slf4j
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final ActorRepository actorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ActorRepository actorRepository1) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository1;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitleIgnoreCase(title)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "title", title));
    }

    @Override
    public List<Movie> findMoviesByTitle(String title) {
        System.out.println(movieRepository.findByTitleContainingIgnoreCase(title).size());
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Movie> findByDirector(Integer id) {
        return movieRepository.findByDirector(id);
    }

    @Override
    public List<Movie> findByActor(Integer id) {
        return movieRepository.findByActor(id);
    }

    @Override
    public List<Actor> findActorsForMovieById(Integer id) {
        return actorRepository.findActorsForMovieById(id);
    }

    @Override
    public void deleteById(Integer id) {

        Movie movieToDelete = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
        movieRepository.deleteById(id);
    }

}
