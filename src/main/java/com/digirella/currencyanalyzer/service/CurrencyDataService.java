package com.digirella.currencyanalyzer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyDataService {
    ResponseEntity<String> saveCurrencyDataByDate(String date);
    ResponseEntity<String> deleteCurrencyDataByDate(String date);
}
