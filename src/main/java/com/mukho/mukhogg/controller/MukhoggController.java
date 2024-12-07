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
        initModels(model);
        return "main";
    }

    @GetMapping("/search")
    public String searchSummoner(@RequestParam String summoner, Model model) {
        if (!summoner.matches("^[a-zA-Z0-9가-힣\\s]+#[a-zA-Z0-9가-힣]+$")) {
            model.addAttribute("error", "소환사명#태그 형식으로 입력해주세요");
            return "main";
        }

        try {
            AccountDto summonerInfo = mukhoggService.getSummonerInfo(summoner);
            model.addAttribute("summonerInfo", summonerInfo);
            
            String puuid = summonerInfo.getPuuid();
            MatchDto matchInfo = mukhoggService.getMatchInfo(puuid);
            model.addAttribute("matchInfo", matchInfo);

            String matchId = matchInfo.getMetadata().getMatchId();
            TimelineDto timelineInfo = mukhoggService.getTimelineDto(matchId);
            model.addAttribute("timelineInfo", timelineInfo);

            String blueTeamGold = mukhoggService.getTotalGold(matchInfo.getInfo().getParticipants(), 100);
            String redTeamGold = mukhoggService.getTotalGold(matchInfo.getInfo().getParticipants(), 200);
            model.addAttribute("blueTeamGold", blueTeamGold);
            model.addAttribute("redTeamGold", redTeamGold);
        } catch (Exception e) {
            initModels(model);
            System.err.println(e.getMessage());
            model.addAttribute("error", "소환사를 찾을 수 없습니다.");
        }
        
        return "main";
    }

    private void initModels(Model model) {
        model.addAttribute("summonerInfo", null);
        model.addAttribute("matchInfo", null);
        model.addAttribute("timelineInfo", null);
        model.addAttribute("blueTeamGold", 0);
        model.addAttribute("redTeamGold", 0);
    }
}