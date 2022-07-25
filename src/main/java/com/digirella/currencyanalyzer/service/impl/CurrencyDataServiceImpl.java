package com.digirella.currencyanalyzer.service.impl;

import com.digirella.currencyanalyzer.client.CbarClient;
import com.digirella.currencyanalyzer.client.model.ValCurs;
import com.digirella.currencyanalyzer.domain.CurrencyData;
import com.digirella.currencyanalyzer.repository.CurrencyDataRepository;
import com.digirella.currencyanalyzer.service.CurrencyDataService;
import com.digirella.currencyanalyzer.service.mapper.CurrencyInfoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyDataServiceImpl implements CurrencyDataService {

    private final CbarClient cbarClient;
    private final CurrencyDataRepository currencyDataRepository;
    private final CurrencyInfoMapper currencyInfoMapper;

    public CurrencyDataServiceImpl(CbarClient cbarClient, CurrencyDataRepository currencyDataRepository, CurrencyInfoMapper currencyInfoMapper) {
        this.cbarClient = cbarClient;
        this.currencyDataRepository = currencyDataRepository;
        this.currencyInfoMapper = currencyInfoMapper;
    }

    @Override
    public ResponseEntity<String> saveCurrencyDataByDate(String date) {
        if(isExist(date)){
            return new ResponseEntity<>("Currency data of the day - " + date + " is already saved.", HttpStatus.CONFLICT);
        } else{
            ValCurs valCurs = cbarClient.getCurrencyInformationForTheDay(date);
            List<CurrencyData> currencyDataList = currencyInfoMapper.mapValCursToCurrencyInfo(valCurs);
            currencyDataRepository.saveAll(currencyDataList);
            return new ResponseEntity<>("Currency data of the day - " + date + " is saved successfully ",HttpStatus.OK);
        }
    }

    private boolean isExist(String date){
        List<CurrencyData> currencyDataList = currencyDataRepository.findCurrencyDataByDate(date);
        return !currencyDataList.isEmpty();
    }


    @Override
    public ResponseEntity<String> deleteCurrencyDataByDate(String date) {
        if(isExist(date)){
            currencyDataRepository.deleteCurrencyInfosByDate(date);
            return new ResponseEntity<>(date, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(date, HttpStatus.NOT_FOUND);
        }
    }
}
