package com.digirella.currencyanalyzer.service.mapper;

import com.digirella.currencyanalyzer.client.model.ValCurs;
import com.digirella.currencyanalyzer.client.model.ValType;
import com.digirella.currencyanalyzer.client.model.Valute;
import com.digirella.currencyanalyzer.domain.CurrencyData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyInfoMapper {

    public List<CurrencyData> mapValCursToCurrencyInfo(ValCurs valCurs){
        String type = "Xarici valyutalar";
        List<Valute> valutes = new ArrayList<>();

        List<ValType> valTypes = valCurs.getValType();
        for(ValType valType: valTypes){
            if(valType.getType().equals(type)){
                valutes = valType.getValute();
                break;
            }
        }

        List<CurrencyData> currencyDataList = new ArrayList<>();
        for(Valute valute: valutes){
            CurrencyData currencyData = mapValuteToCurrencyInfo(valute);
            currencyData.setDate(valCurs.getDate());
            currencyDataList.add(currencyData);
        }

        return currencyDataList;
    }

    private CurrencyData mapValuteToCurrencyInfo(Valute valute){
        CurrencyData currencyData = new CurrencyData();

        currencyData.setCode(valute.getCode());
        currencyData.setDefinition(valute.getName());
        currencyData.setNominal(valute.getNominal());
        currencyData.setPrice(valute.getValue());

        return currencyData;
    }
}
