package com.finalProject.tennisTournament.service;

import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.model.Tournament;
import com.finalProject.tennisTournament.repository.PlayerRepository;
import com.finalProject.tennisTournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;

    // Create a new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Register a player to a tournament
    public Tournament registerPlayer(Long tournamentId, Long playerId) {
        Optional<Tournament> tournamentOpt = tournamentRepository.findById(tournamentId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (tournamentOpt.isPresent() && playerOpt.isPresent()) {
            Tournament tournament = tournamentOpt.get();
            Player player = playerOpt.get();
            tournament.getPlayers().add(player);
            return tournamentRepository.save(tournament);
        }

        return null;
    }
}
