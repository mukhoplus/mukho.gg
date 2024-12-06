package com.mukho.mukhogg.service;

import com.mukho.mukhogg.dto.account.AccountDto;
import com.mukho.mukhogg.dto.matches.match.MatchDto;
import com.mukho.mukhogg.dto.matches.timeline.TimelineDto;

public interface MukhoggService {
    AccountDto getSummonerInfo(String summoner);
    MatchDto getMatchInfo(String puuid);
    TimelineDto getTimelineDto(String puuid);
}
