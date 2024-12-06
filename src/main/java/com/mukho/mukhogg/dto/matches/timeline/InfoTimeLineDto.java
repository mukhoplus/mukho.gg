package com.mukho.mukhogg.dto.matches.timeline;

import java.util.List;

import lombok.Data;

@Data
public class InfoTimeLineDto {
    String endOfGameResult;
    long frameInterval;
    long gameId;
    List<ParticipantTimeLineDto> participants;
    List<FramesTimeLineDto> frames;
}
