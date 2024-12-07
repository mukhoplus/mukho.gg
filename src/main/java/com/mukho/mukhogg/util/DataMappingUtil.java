package com.mukho.mukhogg.util;

import java.util.Map;
import java.util.HashMap;

public class DataMappingUtil {
    public static final Map<Integer, String> SUMMONER_SPELLS = new HashMap<>() {{
        put(1, "SummonerBoost.png");
        put(3, "SummonerExhaust.png");
        put(4, "SummonerFlash.png");
        put(6, "SummonerHaste.png");
        put(7, "SummonerHeal.png");
        put(11, "SummonerSmite.png");
        put(12, "SummonerTeleport.png");
        put(13, "SummonerMana.png");
        put(14, "SummonerDot.png");
        put(21, "SummonerBarrier.png");
        put(30, "SummonerPoroRecall.png");
        put(31, "SummonerPoroThrow.png");
        put(32, "SummonerSnowball.png");
        put(39, "SummonerSnowURFSnowball_Mark.png");
    }};

    public static final Map<Integer, String> RUNE_STYLES = new HashMap<>() {{
        // Precision 룬
        put(8005, "Precision/PressTheAttack/PressTheAttack.png");
        put(8008, "Precision/LethalTempo/LethalTempoTemp.png");
        put(8021, "Precision/FleetFootwork/FleetFootwork.png");
        put(8010, "Precision/Conqueror/Conqueror.png");

        // Domination 룬
        put(8112, "Domination/Electrocute/Electrocute.png");
        put(8124, "Domination/Predator/Predator.png");
        put(8128, "Domination/DarkHarvest/DarkHarvest.png");
        put(9923, "Domination/HailOfBlades/HailOfBlades.png");

        // Sorcery 룬
        put(8214, "Sorcery/SummonAery/SummonAery.png");
        put(8229, "Sorcery/ArcaneComet/ArcaneComet.png");
        put(8230, "Sorcery/PhaseRush/PhaseRush.png");

        // Resolve 룬
        put(8437, "Resolve/GraspOfTheUndying/GraspOfTheUndying.png");
        put(8439, "Resolve/VeteranAftershock/VeteranAftershock.png");
        put(8465, "Resolve/Guardian/Guardian.png");

        // Inspiration 룬
        put(8351, "Inspiration/GlacialAugment/GlacialAugment.png");
        put(8360, "Inspiration/HextechFlashtraption/HextechFlashtraption.png");
        put(8358, "Inspiration/MasterKey/MasterKey.png");
    }};

    public static final Map<Integer, String> SUB_RUNE_STYLES = new HashMap<>() {{
        put(8000, "7201_Precision.png");
        put(8100, "7200_Domination.png");
        put(8200, "7202_Sorcery.png");
        put(8300, "7203_Whimsy.png");
        put(8400, "7204_Resolve.png");
    }};

    public static final Map<Integer, String> GAME_TYPE = new HashMap<>() {{
        put(400, "일반");
        put(420, "솔로랭크");
        put(430, "일반");
        put(440, "자유랭크");
    }};
}
