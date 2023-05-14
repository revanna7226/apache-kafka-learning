package com.revs.kafka;

import com.revs.kafka.config.KafkaConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @Autowired
    private KafkaConsumerConfig kafkaConsumerConfig;


    public KafkaMessageListenerContainer getListener(String topic) {
        ContainerProperties containerProps = new ContainerProperties(topic);
        containerProps.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Object data) {

                System.out.println(data);

            }
        });
        containerProps.setGroupId("TestGroup");
        DefaultKafkaConsumerFactory<Integer, String> cf =
                new DefaultKafkaConsumerFactory<>(kafkaConsumerConfig.consumerConfig());
        KafkaMessageListenerContainer<Integer, String> container =
                new KafkaMessageListenerContainer<>(cf, containerProps);
        return container;
    }

}
