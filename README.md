# rabbitMqProjectWithSpring

from official rabbitmq.com tutorial

only two pom dependencies web and ampq

1. install from intellij maven tab
2.  java -jar target/rabbitMqProjectWithSpring-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender 
(sender will stop in 'duration' time, which you defined from your properties.yml and it when we run it, it creates queue 'hello' to rabbit server automatically from code)
3. java -jar target/rabbitMqProjectWithSpring-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,receiver
