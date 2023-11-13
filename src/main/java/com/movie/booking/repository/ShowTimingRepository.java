package com.movie.booking.repository;

import com.movie.booking.entity.Movie;
import com.movie.booking.entity.ShowTiming;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimingRepository extends JpaRepository<ShowTiming, Long> {

  List<ShowTiming> findByTimingAndMovie(LocalDateTime timing, Movie movie);

  List<ShowTiming> findByDateAndMovie(String date, Movie movie);

}
