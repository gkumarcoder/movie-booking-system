package com.movie.booking.service;

import com.movie.booking.entity.Movie;
import com.movie.booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  private final MovieRepository movieRepository;



  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieByTitle(String title) {
    return movieRepository.findByTitle(title);
  }

  public void bookSeats(Long movieId, int numSeats) {
    Movie movie = movieRepository.findById(movieId)
        .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

    movie.bookSeats(numSeats);
    movieRepository.save(movie);
  }


}

