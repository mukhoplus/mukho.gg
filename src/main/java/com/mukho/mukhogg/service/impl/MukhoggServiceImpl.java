package com.mukho.mukhogg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mukho.mukhogg.dto.account.AccountDto;
import com.mukho.mukhogg.dto.matches.match.MatchDto;
import com.mukho.mukhogg.dto.matches.timeline.TimelineDto;
import com.mukho.mukhogg.service.MukhoggService;

@Service
public class MukhoggServiceImpl implements MukhoggService{
    
    @Value("${riot.api.key}")
    private String riotApiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public AccountDto getSummonerInfo(String summoner) {
        AccountDto summonerInfo = null;

        try {
            String[] riotId = summoner.split("#");

            if (riotId.length < 2) {
                throw new Exception("소환사명#태그 형식으로 입력해주세요.");
            }

            String gameName = riotId[0];
            String tagLine = riotId[1];

            String url = String.format("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", gameName, tagLine, riotApiKey);
            summonerInfo = restTemplate.getForObject(url, AccountDto.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return summonerInfo;
    }

    @Override
    public MatchDto getMatchInfo(String puuid) {
        MatchDto matchInfo = null;

        try {
            List<String> matchIds = getMatchIds(puuid);
            matchInfo = getLastMatchInfo(matchIds);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return matchInfo;
    }

    @Override
    public TimelineDto getTimelineDto(String matchId) {
        TimelineDto timelineInfo = null;

        try {
            String url = String.format("https://asia.api.riotgames.com/lol/match/v5/matches/%s/timeline?api_key=%s", matchId, riotApiKey);
            timelineInfo = restTemplate.getForObject(url, TimelineDto.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return timelineInfo;
    }

    private List<String> getMatchIds(String puuid) {
        List<String> matchIds= null;

        try {
            String url = String.format("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=100&api_key=%s", puuid, riotApiKey);
            matchIds = restTemplate.getForObject(url, List.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return matchIds;
    }

    private MatchDto fetchMatchInfo(String matchId) {
        try {
            String url = String.format("https://asia.api.riotgames.com/lol/match/v5/matches/%s?api_key=%s", matchId, riotApiKey);
            MatchDto matchInfo = restTemplate.getForObject(url, MatchDto.class);
            
            if (matchInfo == null) {
                return null;
            }

            String gameType = matchInfo.getInfo().getGameMode();
            if (gameType.equals("CLASSIC")) {
                return matchInfo;
            }
        } catch (Exception e) {
            System.err.println("매치 정보를 불러오는 중 오류 발생: " + e.getMessage());
        }
        return null;
    }

    private MatchDto getLastMatchInfo(List<String> matchIds) {
        MatchDto lastMatchInfo = null;

        try {
            if (matchIds == null || matchIds.isEmpty()) {
                throw new Exception("최근 매치 기록이 없습니다.");
            }

            for (String matchId : matchIds) {
                MatchDto matchInfo = fetchMatchInfo(matchId);
                if (matchInfo != null) {
                    lastMatchInfo = matchInfo;
                    break;
                }
            }

            if (lastMatchInfo == null) {
                throw new Exception("최근 소환사의 협곡 매치 기록이 없습니다.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return lastMatchInfo;
    }
}
