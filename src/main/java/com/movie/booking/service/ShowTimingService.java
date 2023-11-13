package com.movie.booking.service;

import com.movie.booking.entity.Movie;
import com.movie.booking.entity.ShowTiming;
import com.movie.booking.repository.ShowTimingRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimingService {

  @Autowired
  private ShowTimingRepository showTimingRepository;

  @Autowired
  private MovieService movieService;

  public List<ShowTiming> getShowTimings(LocalDateTime date, String movieTitle) {
    Movie movie = movieService.getMovieByTitle(movieTitle);
    List<ShowTiming> showTimings = showTimingRepository.findByTimingAndMovie(date, movie);
    return showTimings;
  }

}
