package com.digirella.currencyanalyzer.controller;

import com.digirella.currencyanalyzer.service.CurrencyDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency-data")
public class CurrencyDataController {

    private final CurrencyDataService currencyDataService;

    public CurrencyDataController(CurrencyDataService currencyDataService) {
        this.currencyDataService = currencyDataService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCurrencyInfoByDate(@RequestParam String date){
        return currencyDataService.saveCurrencyDataByDate(date);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCurrencyInfoByDate(@RequestParam String date){
        return currencyDataService.deleteCurrencyDataByDate(date);
    }
}
