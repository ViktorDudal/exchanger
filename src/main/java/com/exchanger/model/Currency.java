package com.exchanger.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "currency")
public class Currency {

    @Id
    Long id;

    @Column
    private String ccy;

    @Column
    private String base_ccy;

    @Column
    private Float purchasePrice;

    @Column
    private Float sellingPrice;
}
