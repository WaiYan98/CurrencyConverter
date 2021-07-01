package com.example.currencyconverter.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.currencyconverter.model2.CurrencyCountry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingNames {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<CurrencyCountry> sorting(List<CurrencyCountry> currencyCountryList) {

        List<CurrencyCountry> resultList = new ArrayList<>();
        resultList = currencyCountryList.stream()
                .sorted(new Comparator<CurrencyCountry>() {
                    @Override
                    public int compare(CurrencyCountry c1, CurrencyCountry c2) {
                        return c1.getCurrencyName().compareTo(c2.getCurrencyName());
                    }
                }).collect(Collectors.toList());
        return resultList;
    }
}
