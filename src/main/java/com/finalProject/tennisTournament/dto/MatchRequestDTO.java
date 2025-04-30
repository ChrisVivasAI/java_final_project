package com.finalProject.tennisTournament.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MatchRequestDTO {

    @NotNull
    private Long player1Id;

    @NotNull
    private Long player2Id;

    @NotNull
    private Long winnerId;

    @NotNull
    private Long tournamentId;

    @NotNull
    private LocalDate matchDate;

    @NotNull
    private String score;

    // Getters and Setters
    public Long getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Long player1Id) {
        this.player1Id = player1Id;
    }

    public Long getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Long player2Id) {
        this.player2Id = player2Id;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
