package com.exchanger.model.dto;

import lombok.Data;

@Data
public class CurrencyApi {

    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;
}
