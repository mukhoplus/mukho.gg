package com.mukho.mukhogg.dto.matches.match;

import java.util.List;

import lombok.Data;

@Data
public class MetadataDto {
    String dataVersion;
    String matchId;
    List<String> participants;
}
