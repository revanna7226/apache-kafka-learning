package com.revs.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "amigoscode", groupId = "groupID")
    void listener(String data) {
        System.out.println("Listener Data: " + data + " :-)");
    }

}
