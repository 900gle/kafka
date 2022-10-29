package com.doo.kafka.service;

import com.doo.kafka.dto.Doo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "900gle";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {

        String st = "";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
             st = objectMapper.writeValueAsString(Doo.create(message));


            System.out.println(st);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }




        System.out.println(String.format("Produce message : %s", st));
        this.kafkaTemplate.send(TOPIC, st);
    }
}
