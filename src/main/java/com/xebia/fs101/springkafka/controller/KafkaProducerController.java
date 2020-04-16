package com.xebia.fs101.springkafka.controller;

import com.xebia.fs101.springkafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("kafka")
public class KafkaProducerController {
    private final static String TOPIC = "spring-kafka";
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable(value = "message") String message) {

        kafkaTemplate.send(TOPIC, message);
        return new ResponseEntity<>("Published successfully", OK);
    }

    @PostMapping("/publish/body")
    public ResponseEntity<?> publishBody(@Valid @RequestBody User user) {

        kafkaTemplate.send(TOPIC, user);
        return new ResponseEntity<>("Published Successfully", CREATED);
    }
}


