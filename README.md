# movie-booking-system

The Movie Booking System is a Java-based application designed to streamline the process of browsing and booking movie tickets.

With features like:
1.Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date 

Below is a REST backend API for browsing theatres, shows, and timings based on a chosen date

2.Book movie tickets by selecting a theatre, timing, and preferred seats for the day

This project utilizes Java 17 and is built using Gradle 8.4 for efficient development and dependency management. 


## Prerequisites

Ensure you have the following software installed on your machine:

- Java 17
- Gradle 8.4

## DB RECORD FOR TESTING
-- Insert Movie
INSERT INTO Movies (title, genre, director, release_date)
VALUES ('Inception', 'Sci-Fi', 'Christopher Nolan', '2010-07-16');

-- Insert Theatre
INSERT INTO Theatre (name, location)
VALUES ('Cityplex', 'Downtown');

-- Insert ShowTiming
INSERT INTO ShowTiming (movieid, theatreid, timing)
VALUES (
(SELECT movieId FROM Movies WHERE title = 'Inception'),
(SELECT theatreId FROM Theatre WHERE name = 'Cityplex'),
'2023-12-01T18:30:00'
);



