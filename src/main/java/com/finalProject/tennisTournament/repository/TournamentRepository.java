package com.finalProject.tennisTournament.repository;

import com.finalProject.tennisTournament.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
