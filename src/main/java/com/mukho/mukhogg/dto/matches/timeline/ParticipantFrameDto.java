package com.mukho.mukhogg.dto.matches.timeline;

import lombok.Data;

@Data
public class ParticipantFrameDto {
    ChampionStatsDto championStats;
    int currentGold;
    DamageStatsDto damageStats;
    int goldPerSecond;
    int jungleMinionsKilled;
    int level;
    int minionsKilled;
    int participantId;
    PositionDto position;
    int timeEnemySpentControlled;
    int totalGold;
    int xp;
}
