package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;
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
        List<MatchDto> matches;
        ScoreBoardServiceImpl scoreboard = new ScoreBoardServiceImpl();
        matches = scoreboard.startMatch("Mexico", "Canada");
        matches = scoreboard.finishMatch("Mexico", "Canada");

        assertEquals(0, matches.size());
    }
}