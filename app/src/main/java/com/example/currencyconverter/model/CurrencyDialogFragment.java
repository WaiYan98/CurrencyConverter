package com.example.currencyconverter.model;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.L;
import com.example.currencyconverter.R;
import com.example.currencyconverter.model2.CurrencyCountry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyDialogFragment extends DialogFragment {

    public static final String KEY = "KEY";
    private List<CurrencyCountry> currencyCountryList;

    @BindView(R.id.recy_currencies)
    RecyclerView recyCurrencies;

    private CurrencyDialogFragment() {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.dialog_fragment_currencies, null, false);

        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();

        if (bundle != null) {
            currencyCountryList = bundle.getParcelableArrayList(KEY);
        }

        CurrenciesRecycleViewAdapter currRecy = new CurrenciesRecycleViewAdapter();
        recyCurrencies.setAdapter(currRecy);
        recyCurrencies.setLayoutManager(new LinearLayoutManager(getContext()));
        recyCurrencies.addItemDecoration(new DividerItemDecoration(getActivity().getBaseContext(),
                DividerItemDecoration.VERTICAL));


        Dialog dialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_rectangle_light_white);

        Log.d("tag", "onCreateDialog: " + currencyCountryList);

        return dialog;

    }

    public static CurrencyDialogFragment getNewInstance(String key, List<CurrencyCountry> currencyCountryList) {

        ArrayList<CurrencyCountry> arrayList = new ArrayList<>(currencyCountryList);

        CurrencyDialogFragment cdf = new CurrencyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(key, arrayList);
        cdf.setArguments(bundle);
        return cdf;
    }
}
