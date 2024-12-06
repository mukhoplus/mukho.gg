package com.mukho.mukhogg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukho.mukhogg.dto.account.AccountDto;
import com.mukho.mukhogg.dto.matches.match.MatchDto;
import com.mukho.mukhogg.dto.matches.timeline.TimelineDto;
import com.mukho.mukhogg.service.MukhoggService;

@Controller
public class MukhoggController {
    private final MukhoggService mukhoggService;

    public MukhoggController(MukhoggService mukhoggService) {
        this.mukhoggService = mukhoggService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("summonerInfo", null);
        model.addAttribute("matchInfo", null);
        model.addAttribute("timelineInfo", null);
        return "main";
    }

    @GetMapping("/search")
    public String searchSummoner(@RequestParam String summoner, Model model) {
        try {
            AccountDto summonerInfo = mukhoggService.getSummonerInfo(summoner);
            model.addAttribute("summonerInfo", summonerInfo);
            
            String puuid = summonerInfo.getPuuid();
            MatchDto matchInfo = mukhoggService.getMatchInfo(puuid);
            model.addAttribute("matchInfo", matchInfo);

            String matchId = matchInfo.getMetadata().getMatchId();
            TimelineDto timelineInfo = mukhoggService.getTimelineDto(matchId);
            model.addAttribute("timelineInfo", timelineInfo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            model.addAttribute("summonerInfo", null);
            model.addAttribute("matchInfo", null);
            model.addAttribute("timelineInfo", null);
            model.addAttribute("error", "소환사를 찾을 수 없습니다.");
        }
        
        return "main";
    }
}