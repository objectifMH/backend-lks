/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.repository;

import com.lks.backendtechnicaltest.entity.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author omh
 */

public interface MovieRepository extends JpaRepository<Movie, Integer> {

//  Lister les films réalisés par une personne donnée
    @Query(value = "SELECT * FROM MOVIE m WHERE m.director_id = ?1", nativeQuery = true)
    public List<Movie> findMoviesByDirector(Integer id);

//  Lister les films dans lesquels un acteur donné joue
    @Query(value = "SELECT  m.id, m.title, m.date, m.director_id FROM ACTOR a, actor_movie am, movie m where  am.movie_id = m.id and a.id = am.actor_id and a.id = ?1", nativeQuery = true)
    public List<Movie> findMoviesByActor(Integer id);

    public Optional<Movie> findMoviesByTitleIgnoreCase(String title);

    public List<Movie> findByTitleContainingIgnoreCase(String title);

}
