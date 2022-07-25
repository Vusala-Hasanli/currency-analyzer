package com.digirella.currencyanalyzer.repository;

import com.digirella.currencyanalyzer.domain.CurrencyData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CurrencyDataRepository extends CrudRepository<CurrencyData,Long> {

    @Transactional
    void deleteCurrencyInfosByDate(String date);
    List<CurrencyData> findCurrencyDataByDate(String date);
    List<CurrencyData> findCurrencyDataByDateAndCode(String date, String code);
    List<CurrencyData> findCurrencyDataByCode(String code);

}
