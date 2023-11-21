package com.example.startracker.repository;

import com.example.startracker.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository  extends JpaRepository<Star, Long> {
}
