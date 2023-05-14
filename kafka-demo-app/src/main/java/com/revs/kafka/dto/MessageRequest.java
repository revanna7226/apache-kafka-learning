package com.revs.kafka.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRequest {
    private String topic;
    private String message;
}
