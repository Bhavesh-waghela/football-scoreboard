package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;

import java.util.ArrayList;
import java.util.List;

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
}
