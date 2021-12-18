package com.lks.backendtechnicaltest;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.entity.Director;
import com.lks.backendtechnicaltest.entity.Movie;
import com.lks.backendtechnicaltest.repository.ActorRepository;
import com.lks.backendtechnicaltest.repository.DirectorRepository;
import com.lks.backendtechnicaltest.service.Implementation.ActorServiceImpl;
import com.lks.backendtechnicaltest.service.Implementation.DirectorServiceImpl;
import com.lks.backendtechnicaltest.service.Implementation.MovieServiceImpl;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
@Transactional
public class BackendTechnicalTestApplication implements CommandLineRunner {

    @Autowired
    private ActorServiceImpl actorServiceImpl;

    @Autowired
    private DirectorServiceImpl directorServiceImpl;

    @Autowired
    private MovieServiceImpl movieServiceImpl;

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
        System.out.println();
        System.out.println("*************************");
        System.out.println("* Acteurs               m*");
        System.out.println("*************************");

        // // Création de nouveaux acteurs // //
        Actor newActorSamuel = Actor.builder()
                .name("Samuel L. Jackson")
                .build();

        Actor newActorDenzel = Actor.builder()
                .name("Denzel Washington")
                .build();

        // Affichage nouveaux acteurs //
        System.out.println(newActorSamuel);
        System.out.println(newActorDenzel);

        // Sauvergarder les nouveaux acteurs dans BD //
        try {
            actorServiceImpl.save(newActorDenzel);
            actorServiceImpl.save(newActorSamuel);
        } catch (DataAccessException ex) {
            System.out.println(ex.getCause().getMessage());
        }

        // Affichage des acteurs dans la BD //
        List<Actor> listActors = actorServiceImpl.findAll();
        listActors.forEach(System.out::println);

        // Recherche d'un acteur par id //
        Actor actorForId3 = actorServiceImpl.findById(3);
        System.out.println(actorForId3);

        // Suppression d'un acteur par id : 6//
        //actorServiceImpl.deleteById(6);
        // Affichache des acteurs dans la BD //
        listActors = actorServiceImpl.findAll();
        listActors.forEach(System.out::println);

        // Recherche d'un acteur par nom : "Motoko" //
        Actor actorSearchNameMotoko = actorServiceImpl.findByName("motoko");
        System.out.println();
        System.out.println(actorSearchNameMotoko);

        // Recherche d'une liste d'acteurs avec un nom comportant : "o" //
        List<Actor> listActosRy = actorServiceImpl.findActorsByName("o");
        if (listActosRy.size() > 0) {
            System.out.println("Tous les acteurs avec un nom comportant 'p'");
            listActosRy.forEach(System.out::println);
        }

        /**
         * Réalisateurs
         *
         *
         */
        System.out.println();
        System.out.println("*************************");
        System.out.println("* Réalisateurs          *");
        System.out.println("*************************");

        // // Création de nouveaux réalisateurs // //
        Director newDirectorChristopher = Director.builder()
                .name("Cristoper Nolan")
                .build();

        Director newDirectorDavid = Director.builder()
                .name("David Fincher")
                .build();

        // Affichage nouveaux réalisateurs //
        System.out.println(newDirectorChristopher);
        System.out.println(newDirectorDavid);

        // Sauvergarder les nouveaux realisateurs dans BD //
        directorServiceImpl.save(newDirectorChristopher);
        directorServiceImpl.save(newDirectorDavid);

        // Affichache des realisateurs dans la BD //
        List<Director> listDirectors = directorServiceImpl.findAll();
        listDirectors.forEach(System.out::println);

        // Recherche d'un realisateur par id //
        Director directorForId3 = directorServiceImpl.findById(3);
        System.out.println(directorForId3);

        // Suppression d'un réalisateur par id : 4//
        directorServiceImpl.deleteById(4);

        // Affichage des realisateurs dans la BD //
        listDirectors = directorServiceImpl.findAll();
        listDirectors.forEach(System.out::println);

        // Recherche d'un réalisateur par nom : "Steven Spielberg" //
        Director directorSearchNameSS = directorServiceImpl.findByName("Steven Spielberg");
        System.out.println();
        System.out.println(directorSearchNameSS);

        // Recherche d'une liste de réalisateurs avec un nom comportant : "o" //
        List<Director> listDirectorForO = directorServiceImpl.findDirectorsByName("o");
        if (listDirectorForO.size() > 0) {
            System.out.println("Tous les réalisateurs avec un nom comportant 'o'");
            listDirectorForO.forEach(System.out::println);
        }

        /**
         * Movies
         *
         *
         */
        System.out.println();
        System.out.println("*************************");
        System.out.println("* Films          *");
        System.out.println("*************************");

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

        // Affichage nouveaux films //
        System.out.println(newMoviePrestige);
        System.out.println();
        System.out.println(newMovieSeven);

        // Affichage nouveaux Films //
        System.out.println();
        System.out.println("Affichage des nouveaux films >  ");
        System.out.println();

        System.out.println(newMoviePrestige);
        System.out.println(newMovieSeven);
        System.out.println();

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

        System.out.println(" Les films contenant 'sev'  :");
        movieServiceImpl.findMoviesByTitle("sev")
                .forEach(System.out::println);

        // Affichage des Films d'un réalisateur avec l'id 1 //
        System.out.println();
        System.out.println("Affichage des films réalisés par le réalisateur avec l'id : 1  ");
        movieServiceImpl.findByDirector(1)
                .forEach(System.out::println);
        System.out.println();

        // Affichage des films joué par l'acteur avec l'id : 1 //
        System.out.println();
        System.out.println("Affichage des films de l'acteur qui a pour id : 7  ");
        movieServiceImpl.findByActor(7)
                .forEach(System.out::println);
        System.out.println();

        // Affichage des Acteurs du film qui a pour id : 1 //
        System.out.println();
        System.out.println("Affichage des acteurs du film qui a pour id : 13  ");
        movieServiceImpl.findActorsForMovieById(13)
                .forEach(System.out::println);
        System.out.println();
        

        // Suppression d'un film //
        //movieServiceImpl.deleteById(1);
        
        
        Actor newActor = actorServiceImpl.findById(1);
        Movie newMovie = movieServiceImpl.findById(13);
        System.out.println(newMovie.getActors());
        
        //Directeur a supprimer : 
        Director director5 =  Director.builder()
                .name("Guy ritchie")
                .build();
        directorServiceImpl.save(director5);
//        directorServiceImpl.deleteById(5);

        movieServiceImpl.deleteById(10);
        movieServiceImpl.deleteById(11);
        movieServiceImpl.deleteById(25);
        

    }
}
