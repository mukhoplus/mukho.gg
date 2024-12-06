package com.mukho.mukhogg.dto.matches.match;

import java.util.List;

import lombok.Data;

@Data
public class TeamDto {
    List<BanDto> bans;
    ObjectivesDto objectives;
    int teamId;
    boolean win;
}
