package com.finalProject.tennisTournament.service;

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

    public Match recordMatch(Long player1Id, Long player2Id, Long winnerId, Long tournamentId, Match matchData) {
        Optional<Player> p1 = playerRepository.findById(player1Id);
        Optional<Player> p2 = playerRepository.findById(player2Id);
        Optional<Player> win = playerRepository.findById(winnerId);
        Optional<Tournament> tour = tournamentRepository.findById(tournamentId);

        if (p1.isPresent() && p2.isPresent() && win.isPresent() && tour.isPresent()) {
            Tournament tournament = tour.get();

            if (tournament.getPlayers().contains(p1.get()) && tournament.getPlayers().contains(p2.get())) {
                Match match = new Match();
                match.setPlayer1(p1.get());
                match.setPlayer2(p2.get());
                match.setWinner(win.get());
                match.setTournament(tournament);
                match.setMatchDate(matchData.getMatchDate());
                match.setScore(matchData.getScore());

                if (win.get().getId().equals(p1.get().getId())) {
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
        System.out.println("Looking for match with ID: " + id);
        return matchRepository.findById(id);
    }
}
