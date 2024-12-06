package com.mukho.mukhogg.util;

import org.springframework.stereotype.Component;

@Component
public class DataDragonUtil {
    private static final String VERSION = "14.23.1";
    private static final String BASE_URL = "https://ddragon.leagueoflegends.com/cdn/";
    
    public String getChampionImageUrl(String championName) {
        // championId를 챔피언 이름으로 변환하는 로직 필요
        return BASE_URL + VERSION + "/img/champion/" + championName + ".png";
    }
    
    public String getItemImageUrl(int itemId) {
        return BASE_URL + VERSION + "/img/item/" + itemId + ".png";
    }
    
    public String getSpellImageUrl(int spellId) {
        return BASE_URL + VERSION + "/img/spell/" + DataMappingUtil.SUMMONER_SPELLS.get(spellId);
    }
    
    public String getRuneImageUrl(int runeId) {
        return BASE_URL + "img/perk-images/Styles/" + DataMappingUtil.RUNE_STYLES.get(runeId);
    }

    public String getSubRuneImageUrl(int runeId) {
        return BASE_URL + "img/perk-images/Styles/" + DataMappingUtil.SUB_RUNE_STYLES.get(runeId);
    }

    public String getLaneImageUrl(String teamPosition) {
        return "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-" + teamPosition.toLowerCase() + ".png";
    }
}