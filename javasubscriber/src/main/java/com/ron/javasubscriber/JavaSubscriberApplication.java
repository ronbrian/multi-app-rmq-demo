package com.ron.javasubscriber;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSubscriberApplication {

    private static final boolean NON_DURABLE = false;
    public static final String MY_QUEUE_NAME = "InterviewQueue";

    public static void main(String[] args) {

        SpringApplication.run(JavaSubscriberApplication.class, args);

    }


    @Bean
    public Queue myQueue() {
        return new Queue(MY_QUEUE_NAME, NON_DURABLE);
    }





}


