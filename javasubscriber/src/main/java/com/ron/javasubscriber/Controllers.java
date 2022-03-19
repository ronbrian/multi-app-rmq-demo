package com.ron.javasubscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.ron.javasubscriber.JavaSubscriberApplication.MY_QUEUE_NAME;

@RestController
public class Controllers {
    ArrayList<String> received = new ArrayList<String>();

    @RabbitListener(queues = MY_QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
        received.add(in);
    }

    @RequestMapping(value = "/viewmessages", method = RequestMethod.GET)
    public ArrayList<String> viewMessages() {
        return received;
    }

}
