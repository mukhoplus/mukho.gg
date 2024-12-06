package com.mukho.mukhogg.dto.matches.match;

import java.util.List;

import lombok.Data;

@Data
public class PerkStyleDto {
    String description;
    List<PerkStyleSelectionDto> selections;
    int style;
}
