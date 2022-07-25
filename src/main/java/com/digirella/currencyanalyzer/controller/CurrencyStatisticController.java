package com.digirella.currencyanalyzer.controller;

import com.digirella.currencyanalyzer.domain.CurrencyData;
import com.digirella.currencyanalyzer.service.CurrencyStatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currency-statistic")
public class CurrencyStatisticController {

    private final CurrencyStatisticService currencyStatisticService;

    public CurrencyStatisticController(CurrencyStatisticService currencyStatisticService) {
        this.currencyStatisticService = currencyStatisticService;
    }

    @GetMapping
    public ResponseEntity<List<CurrencyData>> getCurrencyStatistic(@RequestParam(required = false) String valute,
                                                                   @RequestParam(required = false) String date){
        return currencyStatisticService.getCurrencyStatistic(valute,date);
    }

}
