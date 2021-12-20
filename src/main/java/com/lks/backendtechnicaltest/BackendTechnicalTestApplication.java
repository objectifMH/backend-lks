package com.lks.backendtechnicaltest;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Director;
import com.lks.backendtechnicaltest.entity.Movie;
import com.lks.backendtechnicaltest.repository.MovieRepository;
import com.lks.backendtechnicaltest.service.Implementation.ActorServiceImpl;
import com.lks.backendtechnicaltest.service.Implementation.DirectorServiceImpl;
import com.lks.backendtechnicaltest.service.Implementation.MovieServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
@Transactional
@OpenAPIDefinition(info = @Info(title = "Movies API", version = "1.0", description = "Movies, Actors & Directors Information"))

public class BackendTechnicalTestApplication implements CommandLineRunner {

    @Autowired
    private ActorServiceImpl actorServiceImpl;

    @Autowired
    private DirectorServiceImpl directorServiceImpl;

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendTechnicalTestApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Date date = new Date();

        System.out.println("Démarrage du serveur ... " + date);

        /**
         * Acteurs
         *
         *
         */
//        System.out.println();
//        System.out.println("*************************");
//        System.out.println("* Acteurs               ");
//        System.out.println("*************************");

        // // Création de nouveaux acteurs // //
        Actor newActorSamuel = Actor.builder()
                .name("Samuel L. Jackson")
                .build();

        Actor newActorDenzel = Actor.builder()
                .name("Denzel Washington")
                .build();

        // Sauvergarder les nouveaux acteurs dans BD //
        try {
            actorServiceImpl.save(newActorDenzel);
            actorServiceImpl.save(newActorSamuel);
        } catch (DataAccessException ex) {
            System.out.println(ex.getCause().getMessage());
        }

        /**
         * Réalisateurs
         *
         *
         */
//        System.out.println();
//        System.out.println("*************************");
//        System.out.println("* Réalisateurs          *");
//        System.out.println("*************************");

        // // Création de nouveaux réalisateurs // //
        Director newDirectorChristopher = Director.builder()
                .name("Cristoper Nolan")
                .build();

        Director newDirectorDavid = Director.builder()
                .name("David Fincher")
                .build();

        // Sauvergarder les nouveaux realisateurs dans BD //
        directorServiceImpl.save(newDirectorChristopher);
        directorServiceImpl.save(newDirectorDavid);

        /**
         * Movies
         *
         *
         */
//        System.out.println();
//        System.out.println("*************************");
//        System.out.println("* Films                 *");
//        System.out.println("*************************");

        // // Création de nouveaux films // //
        List<Actor> listActorsInit = new ArrayList<>();
        listActorsInit.add(newActorSamuel);
        listActorsInit.add(newActorDenzel);

        Movie newMoviePrestige = Movie.builder()
                .title("Prestige")
                .date(date)
                .director(directorServiceImpl.findById(3))
                .actors(listActorsInit)
                .build();

        Movie newMovieSeven = Movie.builder()
                .title("Seven")
                .date(date)
                .director(directorServiceImpl.findById(2))
                .actors(listActorsInit)
                .build();

        // Sauvergarder les nouveaux Films dans BD //
        movieServiceImpl.save(newMoviePrestige);

        listActorsInit.add(actorServiceImpl.findById(1));
        newMovieSeven.setActors(listActorsInit);
        movieServiceImpl.save(newMovieSeven);

        // Affichage de tous les films dans la BD //
        System.out.println();
        System.out.println("Affichage de tous les films >  ");
        System.out.println();

        List<Movie> listMovies = movieServiceImpl.findAll();
        listMovies.forEach(System.out::println);

        // Affichage des Acteurs du film qui a pour id : 1 //
        System.out.println();
        System.out.println("Affichage des acteurs du film qui a pour id : 13  ");
        movieServiceImpl.findActorsForMovieById(13)
                .forEach(System.out::println);
        System.out.println();

        
    }
}
