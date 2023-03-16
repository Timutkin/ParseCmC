package ru.timutkin.coinmarketcapparsing.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.timutkin.coinmarketcapparsing.store.dto.Cryptocurrency;

import java.util.List;

@Component
@AllArgsConstructor
public class Producer {

    private static final String ROUTE_KEY = "cmc";

    private final DirectExchange directExchange;

    private final RabbitTemplate template;

    public void send(List<Cryptocurrency> cryptocurrencies){
        template.convertAndSend(directExchange.getName(), ROUTE_KEY, cryptocurrencies);
    }

}
