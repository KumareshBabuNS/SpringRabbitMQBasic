package co.jagapps.demos;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
public class SpringBootMultiApplication implements CommandLineRunner {

	@Autowired
	private RabbitProducer myProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myProducer.send();
	}

}