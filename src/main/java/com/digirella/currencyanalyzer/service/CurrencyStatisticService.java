package com.digirella.currencyanalyzer.service;

import com.digirella.currencyanalyzer.domain.CurrencyData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyStatisticService {
    ResponseEntity<List<CurrencyData>> getCurrencyStatistic(String valute, String date);
}
