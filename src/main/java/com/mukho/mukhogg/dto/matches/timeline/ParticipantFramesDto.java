package com.mukho.mukhogg.dto.matches.timeline;

import java.util.Map;

import lombok.Data;

@Data
public class ParticipantFramesDto {
    Map<Integer, ParticipantFrameDto> participantFrames;
}
