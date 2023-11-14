package com.movie.booking.controller;

import com.movie.booking.entity.ShowTiming;
import com.movie.booking.entity.Theatre;
import com.movie.booking.service.ShowTimingService;
import com.movie.booking.service.TheatreService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/ticket-booking")
public class MovieBookingController {

  @Autowired
  private TheatreService theatreService;

  @Autowired
  private ShowTimingService showTimingService;

  @GetMapping("/theatres")
  public ResponseEntity<List<Theatre>> getAllTheatres() {
    List<Theatre> theatres = theatreService.getAllTheatres();
    return new ResponseEntity<>(theatres, HttpStatus.OK);
  }

  @GetMapping("/shows")
  public ResponseEntity<List<ShowTiming>> getShowsByDateAndMovie(
      @RequestParam String date,
      @RequestParam String movieTitle
  ) {
    LocalDateTime chosenDate = LocalDateTime.parse(date);
    List<ShowTiming> shows = showTimingService.getShowTimings(chosenDate, movieTitle);
    return new ResponseEntity<>(shows, HttpStatus.OK);
  }

}

