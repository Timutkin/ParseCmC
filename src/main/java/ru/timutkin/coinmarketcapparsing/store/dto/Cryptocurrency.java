package ru.timutkin.coinmarketcapparsing.store.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cryptocurrency implements Serializable {
    LocalTime localTime;
    String name;
    String price;
}
