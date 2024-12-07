package com.mukho.mukhogg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukho.mukhogg.dto.account.AccountDto;
import com.mukho.mukhogg.dto.matches.match.MatchDto;
import com.mukho.mukhogg.dto.matches.match.ParticipantDto;
import com.mukho.mukhogg.dto.matches.timeline.TimelineDto;
import com.mukho.mukhogg.service.MukhoggService;
import com.mukho.mukhogg.util.DataMappingUtil;

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
            MatchDto matchInfo = mukhoggService.getMatchInfo(summonerInfo.getPuuid());
            TimelineDto timelineInfo = mukhoggService.getTimelineDto(matchInfo.getMetadata().getMatchId());

            model.addAttribute("summonerInfo", summonerInfo);
            model.addAttribute("matchInfo", matchInfo);
            model.addAttribute("timelineInfo", timelineInfo);
            model.addAttribute("gameType", DataMappingUtil.GAME_TYPE);
            List<ParticipantDto> participants = matchInfo.getInfo().getParticipants();
            model.addAllAttributes(calculateTeamStats(participants));
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
        model.addAttribute("gameType", null);
        model.addAttribute("blueTeamGold", 0);
        model.addAttribute("redTeamGold", 0);
        model.addAttribute("blueTeamMaxDealt", 0);
        model.addAttribute("redTeamMaxDealt", 0);
    }

    private Map<String, Object> calculateTeamStats(List<ParticipantDto> participants) {
        Map<String, Object> stats = new HashMap<>();

        stats.put("blueTeamGold", mukhoggService.getTotalGold(participants, 100));
        stats.put("redTeamGold", mukhoggService.getTotalGold(participants, 200));
        stats.put("blueTeamMaxDealt", mukhoggService.getTeamMaxDealt(participants, 100));
        stats.put("redTeamMaxDealt", mukhoggService.getTeamMaxDealt(participants, 200));

        return stats;
    }
}