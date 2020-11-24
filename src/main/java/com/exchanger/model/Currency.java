package com.exchanger.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", allocationSize=1)
    Long id;

    Instant date;
    String convertFrom;
    String convertTo;
    Float purchasePrice;
    Float sellingPrice;
}
