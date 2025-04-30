package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.model.Player;
import com.finalProject.tennisTournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getPlayerRankings() {
        return playerService.getPlayersSortedByWins();
    }
}
