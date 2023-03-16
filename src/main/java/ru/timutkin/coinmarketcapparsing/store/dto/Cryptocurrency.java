package ru.timutkin.coinmarketcapparsing.store.dto;

import lombok.*;


import java.io.Serializable;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
public class Cryptocurrency implements Serializable {
    Date date;
    String name;
    String price;
}
