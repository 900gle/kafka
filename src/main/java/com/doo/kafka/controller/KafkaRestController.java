package com.doo.kafka.controller;

import com.doo.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaRestController {

    private final KafkaProducer producer;

    @Autowired
    KafkaRestController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}
