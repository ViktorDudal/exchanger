package com.exchanger.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyDTO {

    String ccy;

    String base_ccy;

    Float buy;

    Float sale;
}
