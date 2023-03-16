package ru.timutkin.coinmarketcapparsing.task;

import lombok.AllArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.timutkin.coinmarketcapparsing.CoinMarketCapParsingApplication;
import ru.timutkin.coinmarketcapparsing.producer.Producer;
import ru.timutkin.coinmarketcapparsing.store.dto.Cryptocurrency;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
@EnableScheduling
public class ParseCmcTask{

    Connection connection;

    Producer producer;

    @Scheduled(fixedDelay = 30000)
    public void parseTop10CryptoCryptocurrency() throws IOException {
        Document request = connection.newRequest().get();
        LocalTime time = LocalTime.now();
        Element tableOfCryptocurrency = request.getElementsByTag("tbody").first();
        Stream<Element> trs = tableOfCryptocurrency.getElementsByTag("tr").stream().limit(10);
        List<Cryptocurrency> cryptocurrencies = new ArrayList<>();
        for (Element tr : trs.toList()){
            String tdName = tr.getElementsByTag("td").get(2).getElementsByTag("p").first().ownText();
            String tdPrice= tr.getElementsByTag("td").get(3).getElementsByTag("span").first().ownText();
            cryptocurrencies.add( Cryptocurrency.builder()
                    .name(tdName)
                    .price(tdPrice)
                    .localTime(time)
                    .build());
        }
        producer.send(cryptocurrencies);
    }

}
