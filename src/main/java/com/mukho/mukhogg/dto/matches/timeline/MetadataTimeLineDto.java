package com.mukho.mukhogg.dto.matches.timeline;

import java.util.List;

import lombok.Data;

@Data
public class MetadataTimeLineDto {
    String dataVersion;
    String matchId;
    List<String> participants;
}
