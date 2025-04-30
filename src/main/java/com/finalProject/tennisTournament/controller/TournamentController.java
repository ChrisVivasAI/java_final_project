package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.model.Tournament;
import com.finalProject.tennisTournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // Create a new tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    // Get all tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    // Register a player to a tournament
    @PostMapping("/{tournamentId}/register/{playerId}")
    public Tournament registerPlayerToTournament(@PathVariable Long tournamentId, @PathVariable Long playerId) {
        return tournamentService.registerPlayer(tournamentId, playerId);
    }
}