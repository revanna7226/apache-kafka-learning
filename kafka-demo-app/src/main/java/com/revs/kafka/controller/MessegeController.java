package com.revs.kafka.controller;

import com.revs.kafka.KafkaListenerService;
import com.revs.kafka.dto.MessageRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
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
        final String topic = request.getTopic();
        //kafkaTemplate.send("amigoscode", message);
        kafkaTemplate.send(topic, message);
        return "Success";
    }

    @PostMapping("/publish2")
    public void publishMessage2() {
        kafkaTemplate.send("amigoscode", "Hi, Pu!");
    }


    @Autowired
    private KafkaListenerService kafkaListenerService;

	@PostMapping("/listenTo")
    public void listenToDynamicTopic(@RequestBody MessageRequest request) {

        KafkaMessageListenerContainer listener = kafkaListenerService.getListener(request.getTopic());
        listener.start();
    }

}
