package com.live.footballscore.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchDtoTest {

    @Test
    void shouldAddFieldsToTheMatch() {
        MatchDto match = new MatchDto("TeamA", "TeamB", 2, 3);

        assertEquals("TeamA", match.getHomeTeam());
        assertEquals("TeamB", match.getAwayTeam());
        assertEquals(2, match.getHomeTeamScore());
        assertEquals(3, match.getAwayTeamScore());

        match.setHomeTeam("UpdatedTeamA");
        match.setAwayTeam("UpdatedTeamB");
        match.setHomeTeamScore(5);
        match.setAwayTeamScore(6);

        assertEquals("UpdatedTeamA", match.getHomeTeam());
        assertEquals("UpdatedTeamB", match.getAwayTeam());
        assertEquals(5, match.getHomeTeamScore());
        assertEquals(6, match.getAwayTeamScore());
    }

}