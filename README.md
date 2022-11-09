# rabbitMqProjectWithSpring

from oficial rabbitmq.com tutorial

only two pom dipendencies web and ampq

1. install from intellij maven tab
2.  java -jar target/rabbitMqProjectWithSpring-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender 
(sender will stoped in 'durattion' time, which you difined from your properties.yml)
3. java -jar target/rabbitMqProjectWithSpring-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,receiver
