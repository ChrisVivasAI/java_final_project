package com.finalProject.tennisTournament.service;

import com.finalProject.tennisTournament.dto.TournamentRequestDTO;
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

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament createTournament(TournamentRequestDTO dto) {
        Tournament tournament = new Tournament();
        tournament.setName(dto.getName());
        tournament.setLocation(dto.getLocation());
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());
        return tournamentRepository.save(tournament);
    }

    public Tournament registerPlayer(Long tournamentId, Long playerId) {
        Optional<Tournament> tourOpt = tournamentRepository.findById(tournamentId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (tourOpt.isPresent() && playerOpt.isPresent()) {
            Tournament tournament = tourOpt.get();
            tournament.getPlayers().add(playerOpt.get());
            return tournamentRepository.save(tournament);
        }

        return null;
    }
}
