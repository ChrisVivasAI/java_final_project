package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Create a new player
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // Get all players
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Get player by ID
    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }


    @GetMapping("/sorted")
    public List<Player> getPlayersSortedByWins() {
        return playerService.getPlayersSortedByWins();
    }

    @GetMapping("/rankings")
    public List<Player> getRankings() {
        return playerService.getPlayersSortedByWins();
    }

}