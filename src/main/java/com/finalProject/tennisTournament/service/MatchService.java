package com.finalProject.tennisTournament.service;

import com.finalProject.tennisTournament.dto.MatchRequestDTO;
import com.finalProject.tennisTournament.model.Match;
import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.model.Tournament;
import com.finalProject.tennisTournament.repository.MatchRepository;
import com.finalProject.tennisTournament.repository.PlayerRepository;
import com.finalProject.tennisTournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Match recordMatch(MatchRequestDTO dto) {
        Optional<Player> p1 = playerRepository.findById(dto.getPlayer1Id());
        Optional<Player> p2 = playerRepository.findById(dto.getPlayer2Id());
        Optional<Player> win = playerRepository.findById(dto.getWinnerId());
        Optional<Tournament> tour = tournamentRepository.findById(dto.getTournamentId());

        if (p1.isPresent() && p2.isPresent() && win.isPresent() && tour.isPresent()) {
            Tournament tournament = tour.get();

            if (tournament.getPlayers().contains(p1.get()) && tournament.getPlayers().contains(p2.get())) {
                Match match = new Match();
                match.setPlayer1(p1.get());
                match.setPlayer2(p2.get());
                match.setWinner(win.get());
                match.setTournament(tournament);
                match.setMatchDate(dto.getMatchDate());
                match.setScore(dto.getScore());

                // Update stats
                if (dto.getWinnerId().equals(p1.get().getId())) {
                    p1.get().setWins(p1.get().getWins() + 1);
                    p2.get().setLosses(p2.get().getLosses() + 1);
                } else {
                    p2.get().setWins(p2.get().getWins() + 1);
                    p1.get().setLosses(p1.get().getLosses() + 1);
                }

                playerRepository.save(p1.get());
                playerRepository.save(p2.get());

                return matchRepository.save(match);
            }
        }

        return null;
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }
}
