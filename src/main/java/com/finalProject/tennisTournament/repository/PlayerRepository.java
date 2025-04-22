package com.finalProject.tennisTournament.repository;

import com.finalProject.tennisTournament.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

