package com.example.rabbitmqprojectwithspring;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = "Queue-1")
    // if yuo sent message by string or plain object
//    public void getMessage(String message) {
//        System.out.println(message);
//    }
//    public void getMessage(Person person) {
//        System.out.println(person.getName());
//    }
    public void getMessage(byte[] message) {
        Person deserializePerson = (Person) SerializationUtils.deserialize(message);
        System.out.println(deserializePerson.getName());
    }
}
