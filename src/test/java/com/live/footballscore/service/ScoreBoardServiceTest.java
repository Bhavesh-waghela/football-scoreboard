package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;
import com.live.footballscore.dto.ScoreDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardServiceTest {

    @Test
    void startMatch_shouldAddNewMatchToScoreboard() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        List<MatchDto> matches = scoreboard.startMatch("Mexico", "Canada");

        assertEquals(1, matches.size());
    }

    @Test
    void finishMatch_shouldRemoveMatchFromScoreboard() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        scoreboard.startMatch("Mexico", "Canada");
        List<MatchDto> matches = scoreboard.finishMatch("Mexico", "Canada");

        assertEquals(0, matches.size());
    }

    @Test
    void updateScore_shouldUpdateMatchScore() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        scoreboard.startMatch("Mexico", "Canada");

        ScoreDto score = new ScoreDto(0, 5);
        List<MatchDto> matches = scoreboard.updateScore("Mexico", "Canada", score);

        assertEquals(0, matches.get(0).getHomeTeamScore());
        assertEquals(5, matches.get(0).getAwayTeamScore());
    }
}