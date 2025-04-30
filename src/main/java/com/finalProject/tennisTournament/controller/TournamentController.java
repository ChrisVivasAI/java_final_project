package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.dto.TournamentRequestDTO;
import com.finalProject.tennisTournament.model.Tournament;
import com.finalProject.tennisTournament.service.TournamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament createTournament(@Valid @RequestBody TournamentRequestDTO dto) {
        return tournamentService.createTournament(dto);
    }

    @PostMapping("/{id}/players/{playerId}")
    public Tournament registerPlayer(@PathVariable Long id, @PathVariable Long playerId) {
        return tournamentService.registerPlayer(id, playerId);
    }
}
