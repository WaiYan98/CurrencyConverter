package com.example.currencyconverter.model;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;
import com.example.currencyconverter.model2.CurrencyCountry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyDialogFragment extends DialogFragment {

    @BindView(R.id.img_back_key)
    ImageView imgBackKey;
    public static final String KEY1 = "KEY1";
    public static final String KEY2 = "KEY2";
    private List<CurrencyCountry> currencyCountryList;
    private boolean btn;
    private Dialog dialog;

    @BindView(R.id.recy_currencies)
    RecyclerView recyCurrencies;
    private CurrenciesRecycleViewAdapter.CallBack callBack;

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
            btn = bundle.getBoolean(KEY1);
            currencyCountryList = bundle.getParcelableArrayList(KEY2);
            Log.d("tag", "onCreateDialog: " + btn);
        }

        CurrenciesRecycleViewAdapter currRecy = new CurrenciesRecycleViewAdapter((CurrenciesRecycleViewAdapter.CallBack)
                this.getActivity(),
                () -> {
                    dialog.cancel();
                },
                currencyCountryList, btn);
        recyCurrencies.setAdapter(currRecy);
        recyCurrencies.setLayoutManager(new LinearLayoutManager(getContext()));
        recyCurrencies.addItemDecoration(new DividerItemDecoration(getActivity().getBaseContext(),
                DividerItemDecoration.VERTICAL));


        dialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_rectangle_light_white);

        imgBackKey.setOnClickListener(v -> {
            dialog.cancel();
        });


        return dialog;

    }

    public static CurrencyDialogFragment getNewInstance(String key1, boolean btn,
                                                        String key2, List<CurrencyCountry> currencyCountryList) {

        ArrayList<CurrencyCountry> arrayList = new ArrayList<>(currencyCountryList);

        CurrencyDialogFragment cdf = new CurrencyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(key1, btn);
        bundle.putParcelableArrayList(key2, arrayList);
        cdf.setArguments(bundle);
        return cdf;
    }
}
