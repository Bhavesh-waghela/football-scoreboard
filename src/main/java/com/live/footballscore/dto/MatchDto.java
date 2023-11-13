package com.live.footballscore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MatchDto {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private LocalDateTime startTime;

    public void updateScores(int newHomeTeamScore, int newAwayTeamScore) {
        this.homeTeamScore = newHomeTeamScore;
        this.awayTeamScore = newAwayTeamScore;
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

}
