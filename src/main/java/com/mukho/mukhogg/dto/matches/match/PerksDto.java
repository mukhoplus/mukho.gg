package com.mukho.mukhogg.dto.matches.match;

import java.util.List;

import lombok.Data;

@Data
public class PerksDto {
    PerkStatsDto statPerks;
    List<PerkStyleDto> styles;
}
