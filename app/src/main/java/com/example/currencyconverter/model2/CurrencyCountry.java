package com.example.currencyconverter.model2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrencyCountry implements Parcelable {

    private String alpha3;
    private String currencyId;
    private String currencyName;
    private String currencySymbol;
    private String id;
    private String name;

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyCountries{" +
                "alpha3='" + alpha3 + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    protected CurrencyCountry(Parcel in) {
        alpha3 = in.readString();
        currencyId = in.readString();
        currencyName = in.readString();
        currencySymbol = in.readString();
        id = in.readString();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(alpha3);
        dest.writeString(currencyId);
        dest.writeString(currencyName);
        dest.writeString(currencySymbol);
        dest.writeString(id);
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CurrencyCountry> CREATOR = new Parcelable.Creator<CurrencyCountry>() {
        @Override
        public CurrencyCountry createFromParcel(Parcel in) {
            return new CurrencyCountry(in);
        }

        @Override
        public CurrencyCountry[] newArray(int size) {
            return new CurrencyCountry[size];
        }
    };
}