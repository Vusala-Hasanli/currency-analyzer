package com.digirella.currencyanalyzer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CurrencyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nominal;
    private String definition;
    private String code;
    private String price;
    private String date;

}
