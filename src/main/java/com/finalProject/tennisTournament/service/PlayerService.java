package com.finalProject.tennisTournament.service;

import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Create new player
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Get all players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Get player by ID
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    // Sort players by wins (descending)
    public List<Player> getPlayersSortedByWins() {
        return playerRepository.findAll().stream()
                .sorted((a, b) -> b.getWins() - a.getWins())
                .toList();
    }

    // Update a player (optional for later)
    public Player updatePlayer(Long id, Player updatedPlayer) {
        Optional<Player> existing = playerRepository.findById(id);
        if (existing.isPresent()) {
            Player player = existing.get();
            player.setName(updatedPlayer.getName());
            player.setAge(updatedPlayer.getAge());
            player.setWins(updatedPlayer.getWins());
            player.setLosses(updatedPlayer.getLosses());
            return playerRepository.save(player);
        }
        return null;
    }
}
