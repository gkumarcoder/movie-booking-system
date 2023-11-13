package com.movie.booking.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name = "theatre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "theatreId")
public class Theatre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "theatreId")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "location")
  private String location;

  @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<ShowTiming> showTimings = new HashSet<>();

}

