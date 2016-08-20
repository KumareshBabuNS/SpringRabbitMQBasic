package co.jagapps.demos;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jaime on 8/20/16.
 */
@Service
@EnableRabbit
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${app.queueName}", durable = "true"),
        exchange = @Exchange(value = "${app.exchangeName}", durable = "true", type = ExchangeTypes.DIRECT))
)
public class RabbitConsumer {

    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo);
    }
}
