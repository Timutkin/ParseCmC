package ru.timutkin.coinmarketcapparsing.producer;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.timutkin.coinmarketcapparsing.store.dto.Cryptocurrency;

import java.util.List;

@Service
public class Producer {

    @Value("${spring.rabbitmq.routekey}")
    private String routeKey;

    private final DirectExchange directExchange;
    private final RabbitTemplate template;

    public Producer(DirectExchange directExchange, RabbitTemplate template) {
        this.directExchange = directExchange;
        this.template = template;
    }

    public void send(List<Cryptocurrency> cryptocurrencies) {
        template.convertAndSend(directExchange.getName(), routeKey, cryptocurrencies);
    }

}
