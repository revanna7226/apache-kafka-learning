package com.revs.kafka.controller;

import com.revs.kafka.dto.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessegeController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessegeController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public void publishMessage(@RequestBody MessageRequest request) {
        kafkaTemplate.send("amigoscode", request.getMessage());
    }

    @PostMapping("/publish2")
    public void publishMessage2() {
        kafkaTemplate.send("amigoscode", "Hi, Pu!");
    }

}
