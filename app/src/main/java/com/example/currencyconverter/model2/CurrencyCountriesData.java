package com.example.currencyconverter.model2;

import com.google.gson.annotations.SerializedName;

public class CurrencyCountriesData {

    @SerializedName("results")
    private Result results;

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CurrencyName{" +
                "results=" + results +
                '}';
    }
}
