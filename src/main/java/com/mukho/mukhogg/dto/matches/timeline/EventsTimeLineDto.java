package com.mukho.mukhogg.dto.matches.timeline;

import lombok.Data;

@Data
public class EventsTimeLineDto {
    long timestamp;
    long realTimestamp;
    String type;
}
