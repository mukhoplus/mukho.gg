package com.mukho.mukhogg.dto.matches.timeline;

import lombok.Data;

@Data
public class DamageStatsDto {
    int magicDamageDone;
    int magicDamageDoneToChampions;
    int magicDamageTaken;
    int physicalDamageDone;
    int physicalDamageDoneToChampions;
    int physicalDamageTaken;
    int totalDamageDone;
    int totalDamageDoneToChampions;
    int totalDamageTaken;
    int trueDamageDone;
    int trueDamageDoneToChampions;
    int trueDamageTaken;
}
