package com.live.footballscore.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDtoTest {

    @Test
    void shouldAddFieldsToScore(){
        ScoreDto score = new ScoreDto(2, 3);

        assertEquals(2, score.getHomeTeamScore());
        assertEquals(3, score.getAwayTeamScore());

        score.setHomeTeamScore(5);
        score.setAwayTeamScore(6);

        assertEquals(5, score.getHomeTeamScore());
        assertEquals(6, score.getAwayTeamScore());
    }

}