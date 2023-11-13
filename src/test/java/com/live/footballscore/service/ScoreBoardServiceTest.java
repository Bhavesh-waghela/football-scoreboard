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

    @Test
    void getMatchesSummary_shouldReturnMatches() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        scoreboard.startMatch("TeamA", "TeamB");
        scoreboard.startMatch("TeamC", "TeamD");
        scoreboard.updateScore("TeamA", "TeamB", new ScoreDto(2, 3));
        scoreboard.updateScore("TeamC", "TeamD", new ScoreDto(3, 4));

        assertEquals(2, scoreboard.getMatchesSummary().size());
        assertEquals("TeamC", scoreboard.getMatchesSummary().get(0).getHomeTeam());
        assertEquals("TeamD", scoreboard.getMatchesSummary().get(0).getAwayTeam());
        assertEquals(7, scoreboard.getMatchesSummary().get(0).getTotalScore());
    }
}