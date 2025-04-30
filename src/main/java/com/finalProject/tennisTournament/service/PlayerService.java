package com.finalProject.tennisTournament.service;

import com.finalProject.tennisTournament.dto.PlayerRequestDTO;
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

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(PlayerRequestDTO dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setWins(dto.getWins());
        player.setLosses(dto.getLosses());
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, PlayerRequestDTO dto) {
        Optional<Player> optional = playerRepository.findById(id);
        if (optional.isPresent()) {
            Player player = optional.get();
            player.setName(dto.getName());
            player.setAge(dto.getAge());
            player.setWins(dto.getWins());
            player.setLosses(dto.getLosses());
            return playerRepository.save(player);
        }
        return null;
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public List<Player> getPlayersSortedByWins() {
        return playerRepository.findAllByOrderByWinsDesc();
    }

}
