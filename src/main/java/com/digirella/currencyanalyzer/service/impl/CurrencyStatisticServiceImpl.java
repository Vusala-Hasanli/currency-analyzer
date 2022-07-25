package com.digirella.currencyanalyzer.service.impl;

import com.digirella.currencyanalyzer.domain.CurrencyData;
import com.digirella.currencyanalyzer.repository.CurrencyDataRepository;
import com.digirella.currencyanalyzer.service.CurrencyStatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyStatisticServiceImpl implements CurrencyStatisticService {
    private final CurrencyDataRepository currencyDataRepository;

    public CurrencyStatisticServiceImpl(CurrencyDataRepository currencyDataRepository) {
        this.currencyDataRepository = currencyDataRepository;
    }

    @Override
    public ResponseEntity<List<CurrencyData>> getCurrencyStatistic(String valute, String date) {
        List<CurrencyData> currencyDataList;

        if(valute == null && date == null){
            throw new IllegalArgumentException("Both parameters are null. One of them must has a value");
        } else if(valute != null & date != null){
            currencyDataList = currencyDataRepository.findCurrencyDataByDateAndCode(date, valute);
        } else if(valute == null){
            currencyDataList = currencyDataRepository.findCurrencyDataByDate(date);
        } else {
            currencyDataList = currencyDataRepository.findCurrencyDataByCode(valute);
        }

        return new ResponseEntity<>(currencyDataList, HttpStatus.OK);
    }

}
