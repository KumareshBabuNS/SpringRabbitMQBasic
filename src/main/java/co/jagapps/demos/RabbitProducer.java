package co.jagapps.demos;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by jaime on 8/20/16.
 */
@Service
public class RabbitProducer {

    @Value("${app.exchangeName}")
    String exchangeName;

    @Value("${app.queueName}")
    String queueName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    public void send() {
        System.out.println("Writing message in RabbitTemplate ...");
        this.rabbitTemplate.convertAndSend(queueName,"Always be kind");
        System.out.println("... Message written in RabbitTemplate");
    }
}
