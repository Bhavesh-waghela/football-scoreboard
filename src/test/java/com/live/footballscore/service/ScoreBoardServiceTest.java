package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;
import com.live.footballscore.dto.ScoreDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
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

    @Test
    void getMatchesSummary_shouldReturnMatchesOrderedByTotalScoreAndStartTime() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();

        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", new ScoreDto(0, 5));

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", new ScoreDto(10, 2));

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Germany", "France", new ScoreDto(2, 2));

        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", new ScoreDto(6, 6));

        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", new ScoreDto(3, 1));

        assertEquals("Uruguay", scoreboard.getMatchesSummary().get(0).getHomeTeam());
        assertEquals("Italy", scoreboard.getMatchesSummary().get(0).getAwayTeam());

        assertEquals("Spain", scoreboard.getMatchesSummary().get(1).getHomeTeam());
        assertEquals("Brazil", scoreboard.getMatchesSummary().get(1).getAwayTeam());

        assertEquals("Mexico", scoreboard.getMatchesSummary().get(2).getHomeTeam());
        assertEquals("Canada", scoreboard.getMatchesSummary().get(2).getAwayTeam());

        assertEquals("Argentina", scoreboard.getMatchesSummary().get(3).getHomeTeam());
        assertEquals("Australia", scoreboard.getMatchesSummary().get(3).getAwayTeam());

        assertEquals("Germany", scoreboard.getMatchesSummary().get(4).getHomeTeam());
        assertEquals("France", scoreboard.getMatchesSummary().get(4).getAwayTeam());
    }

    @Test
    void getTotalScore_shouldReturnSumOfHomeAndAwayTeamScores() {
        MatchDto match = new MatchDto("TeamA", "TeamB", 2, 3, LocalDateTime.now());
        assertEquals(5, match.getTotalScore());
    }

    @Test
    void getStartTime_shouldReturnMatchStartTime() {
        MatchDto match = new MatchDto("TeamA", "TeamB", 2, 3, LocalDateTime.now());
        assertNotNull(match.getStartTime());
        assertTrue(match.getStartTime().isBefore(LocalDateTime.now()));
    }

    @Test
    void getMatchesSummary_shouldReturnEmptyListWhenNoMatches() {
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        assertTrue(scoreboard.getMatchesSummary().isEmpty());
    }
}