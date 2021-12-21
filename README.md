# backend-lks
Api rest, JPA, H2, Java8, Open Api pour la documentation

Documentation à l'aide de Open Api à retrouver à l'adresse : http://localhost:8090/swagger-ui/index.html#/

Les routes demandées au minimum pour cet exercice vont permettre de :

- Lister les films réalisés par une personne donnée :
  id Director, 
  http://localhost:8090/lks/backend/v1/movies/searchMovies/director/{id}

- Lister les films dans lesquels un acteur donné joue :
  id  Actor,
  http://localhost:8090/lks/backend/v1/movies/searchMovies/actor/{id}

- Lister les acteurs d'un film :
  id Movie,
  http://localhost:8090/lks/backend/v1/movies/searchActors/{id}

