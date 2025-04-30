package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.model.Match;
import com.finalProject.tennisTournament.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/record")
    public Match recordMatch(
            @RequestParam Long player1Id,
            @RequestParam Long player2Id,
            @RequestParam Long winnerId,
            @RequestParam Long tournamentId,
            @RequestBody Match matchData
    ) {
        return matchService.recordMatch(player1Id, player2Id, winnerId, tournamentId, matchData);
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }
}
