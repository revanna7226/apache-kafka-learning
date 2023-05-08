package com.revs.kafka.controller;

import com.revs.kafka.dto.MessageRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/messages")
public class MessegeController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessegeController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    @CrossOrigin("*")
    public String publishMessage(@RequestBody MessageRequest request) throws ExecutionException, InterruptedException {
        final String message = request.getMessage();
        kafkaTemplate.send("amigoscode", message);
        return "Success";
    }

    @PostMapping("/publish2")
    public void publishMessage2() {
        kafkaTemplate.send("amigoscode", "Hi, Pu!");
    }

}
