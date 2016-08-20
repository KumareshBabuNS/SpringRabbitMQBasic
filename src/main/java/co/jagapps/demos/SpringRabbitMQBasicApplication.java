package co.jagapps.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitMQBasicApplication implements CommandLineRunner {

	@Autowired
	private RabbitProducer myProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMQBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending first message ...");
		myProducer.send();
		System.out.println("... First message sent");
	}
}