package com.live.footballscore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreDto {
    private int homeTeamScore;
    private int awayTeamScore;
}
