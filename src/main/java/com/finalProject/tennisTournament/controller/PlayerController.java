package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.dto.PlayerRequestDTO;
import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player createPlayer(@Valid @RequestBody PlayerRequestDTO dto) {
        return playerService.createPlayer(dto);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @Valid @RequestBody PlayerRequestDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
