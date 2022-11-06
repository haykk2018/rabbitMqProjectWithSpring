package com.example.rabbitmqprojectwithspring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("send")
    public String send() {
        rabbitTemplate.convertAndSend("Queue-1", "hello");
        return "string message sent";
    }

    @GetMapping("send-object/{name}")
    public String sendObject(@PathVariable String name) {
        Person person = new Person(1, name);
        rabbitTemplate.convertAndSend("Queue-1", person);
        return "object message sent";
    }

    @GetMapping("send-bytearray-object/{name}")
    public String sendByteArrayObject(@PathVariable String name) {
        Person person = new Person(1, name);
        byte[] data = SerializationUtils.serialize(person);
        rabbitTemplate.convertAndSend("Queue-1", data);
        return "byte array message sent";
    }
    //alternative variant for byte[] messages
    /* @RabbitListener(queues = "Mobile")
    public void getMessage(byte[] message) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(message);
        ObjectInput in = new ObjectInputStream(bis);
        Person p = (Person) in.readObject();
        in.close();
        bis.close();
        System.out.println(p.getName());
    }*/

    //"Direct-Exchange,Fanout-Exchange,Topic-Exchange

    /*@GetMapping("/test/{name}")
	public String testAPI(@PathVariable("name") String name) {
		Person p = new Person(1L, name);
		rabbitTemplate.convertAndSend("Mobile", p);
		rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", p);
		rabbitTemplate.convertAndSend("Fanout-Exchange", "", p);
		rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", p);
		return "Success";
	}*/

    //Headers-Exchange

    /*  @GetMapping("/test/{name}")
    public String testAPI(@PathVariable("name") String name) throws IOException {
        Person p = new Person(1L, name);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(p);
        out.flush();
        out.close();

        byte[] byteMessage = bos.toByteArray();
        bos.close();

        Message message = MessageBuilder.withBody(byteMessage)
                .setHeader("item1", "mobile")
                .setHeader("item2", "television").build();

        rabbitTemplate.send("Headers-Exchange", "", message);

        return "Success";
    }*/
}
