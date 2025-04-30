package com.finalProject.tennisTournament.controller;

import com.finalProject.tennisTournament.dto.MatchRequestDTO;
import com.finalProject.tennisTournament.model.Match;
import com.finalProject.tennisTournament.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public Match recordMatch(@Valid @RequestBody MatchRequestDTO dto) {
        return matchService.recordMatch(dto);
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }
}
