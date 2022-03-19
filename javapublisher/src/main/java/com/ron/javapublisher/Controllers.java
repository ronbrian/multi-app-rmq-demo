package com.ron.javapublisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
public class Controllers {
    @Autowired
    private RabbitTemplate template ;

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());



    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public HashMap<String, Object> createMessage() {
        HashMap<String, Object> response = new HashMap<>();
        try {
            template.convertAndSend("InterviewQueue", "Message Sent at time " + formatter.format(date));
            response.put("Success", "Message Sent");
        }catch (Exception e){
            response.put("error", e.toString());
        }
        return response;
    }

}
