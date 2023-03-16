package ru.timutkin.coinmarketcapparsing.config;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.timutkin.coinmarketcapparsing.web.constant.CoinMarketCapConstant;


@Configuration
public class DocumentConfig {

    private static final String USER_AGENT = "Chrome";

    @Bean
    public Connection connectionCoinMarketCap() {
        return Jsoup.connect(CoinMarketCapConstant.MAIN_URL)
                .userAgent(USER_AGENT)
                .referrer("https://www.google.com/")
                .method(Connection.Method.GET)
                .timeout(5000);
    }

}
