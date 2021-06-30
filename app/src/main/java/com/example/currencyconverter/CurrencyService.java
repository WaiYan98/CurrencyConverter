package com.example.currencyconverter;

import com.example.currencyconverter.model2.CurrencyCountriesData;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyService {

    @GET("api/v7/countries?&apiKey=8a93e2772294db12e233")
    Single<CurrencyCountriesData> getAllCurrencyCountriesData();
}
