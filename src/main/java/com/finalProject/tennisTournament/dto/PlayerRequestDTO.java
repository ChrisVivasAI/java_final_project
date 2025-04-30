package com.finalProject.tennisTournament.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlayerRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a non-negative number")
    private Integer age;

    @NotNull(message = "Wins are required")
    @Min(value = 0, message = "Wins must be a non-negative number")
    private Integer wins;

    @NotNull(message = "Losses are required")
    @Min(value = 0, message = "Losses must be a non-negative number")
    private Integer losses;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
