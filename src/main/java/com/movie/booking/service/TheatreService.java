package com.movie.booking.service;

import com.movie.booking.entity.Movie;
import com.movie.booking.entity.ShowTiming;
import com.movie.booking.entity.Theatre;
import com.movie.booking.repository.MovieRepository;
import com.movie.booking.repository.ShowTimingRepository;
import com.movie.booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

  @Autowired
  private TheatreRepository theatreRepository;

  @Autowired
  private ShowTimingRepository showTimingRepository;

  @Autowired
  private MovieRepository movieRepository;

  public List<Theatre> getAllTheatres() {
    return theatreRepository.findAll();
  }

  public List<ShowTiming> getShowTimings(String movieTitle, String date) {
    Movie movie = movieRepository.findByTitle(movieTitle);
    List<Theatre> theatres = theatreRepository.findAll();

    return showTimingRepository.findByDateAndMovie(date, movie);
  }
}

