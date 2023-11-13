package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;
import com.live.footballscore.dto.ScoreDto;

import java.util.*;

public class ScoreBoardServiceImpl implements ScoreBoardService{
    private List<MatchDto> matches;

    public ScoreBoardServiceImpl() {
        this.matches = new ArrayList<>();
    }
    @Override
    public List<MatchDto> startMatch(String homeTeam, String awayTeam) {
        MatchDto match = new MatchDto(homeTeam, awayTeam, 0, 0);
        matches.add(match);
        return matches;
    }

    @Override
    public List<MatchDto> finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
        return matches;
    }

    @Override
    public List<MatchDto> updateScore(String homeTeam, String awayTeam, ScoreDto score) {
        matches.stream()
                .filter(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Match not found"))
                .updateScores(score.getHomeTeamScore(), score.getAwayTeamScore());

        return matches;
    }

    @Override
    public List<MatchDto> getMatchesSummary() {
        List<MatchDto> summary = new ArrayList<>(matches);
        summary.sort(Comparator.comparing(MatchDto::getTotalScore).reversed());
        return summary;
    }
}