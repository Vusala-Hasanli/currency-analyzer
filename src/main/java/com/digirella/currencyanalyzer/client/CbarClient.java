package com.digirella.currencyanalyzer.client;

import com.digirella.currencyanalyzer.client.model.ValCurs;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CbarClient {

    public ValCurs getCurrencyInformationForTheDay(String date){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.cbar.az/currencies/{date}.xml", ValCurs.class, date);
    }

}
