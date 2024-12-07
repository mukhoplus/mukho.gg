package com.mukho.mukhogg.service;

import java.util.List;

import com.mukho.mukhogg.dto.account.AccountDto;
import com.mukho.mukhogg.dto.matches.match.MatchDto;
import com.mukho.mukhogg.dto.matches.match.ParticipantDto;
import com.mukho.mukhogg.dto.matches.timeline.TimelineDto;

public interface MukhoggService {
    AccountDto getSummonerInfo(String summoner);
    MatchDto getMatchInfo(String puuid);
    TimelineDto getTimelineDto(String matchId);
    String getTotalGold(List<ParticipantDto> participants, int teamId);
    int getTeamMaxDealt(List<ParticipantDto> participants, int teamId);
}
