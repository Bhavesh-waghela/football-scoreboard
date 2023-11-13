package com.live.footballscore.service;

import com.live.footballscore.dto.MatchDto;

import java.util.List;

public interface ScoreBoardService {
    List<MatchDto> startMatch(String homeTeam, String awayTeam);

    List<MatchDto> finishMatch(String homeTeam, String awayTeam);
}
