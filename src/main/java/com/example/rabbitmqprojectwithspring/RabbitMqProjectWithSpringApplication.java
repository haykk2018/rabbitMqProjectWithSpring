package com.example.rabbitmqprojectwithspring;

import com.example.rabbitmqprojectwithspring.tut1.RabbitAmqpTutorialsRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqProjectWithSpringApplication {

    //it's a default profile(set from application.yml)
    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to cntrol its behavior.\n");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }
    // if we run without 'usage_message'(default) profile go this code
    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProjectWithSpringApplication.class, args);
    }

}
