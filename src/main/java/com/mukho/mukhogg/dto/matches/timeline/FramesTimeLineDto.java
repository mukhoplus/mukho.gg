package com.mukho.mukhogg.dto.matches.timeline;

import java.util.List;

import lombok.Data;

@Data
public class FramesTimeLineDto {
    List<EventsTimeLineDto> events;
    ParticipantFramesDto participantFrames;
    int timestamp;
}
