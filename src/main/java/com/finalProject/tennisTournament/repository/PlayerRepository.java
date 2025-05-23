package com.finalProject.tennisTournament.repository;

import com.finalProject.tennisTournament.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByOrderByWinsDesc();
}
