package com.example.currencyconverter.model;

import android.app.Dialog;
import android.os.Bundle;
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

import com.example.currencyconverter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyDialogFragment extends DialogFragment {

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

        CurrenciesRecycleViewAdapter currRecy = new CurrenciesRecycleViewAdapter();
        recyCurrencies.setAdapter(currRecy);
        recyCurrencies.setLayoutManager(new LinearLayoutManager(getContext()));
        recyCurrencies.addItemDecoration(new DividerItemDecoration(getActivity().getBaseContext(),
                DividerItemDecoration.VERTICAL));


        Dialog dialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_rectangle_light_white);

        return dialog;

    }

    public static CurrencyDialogFragment getNewInstance() {

        CurrencyDialogFragment cdf = new CurrencyDialogFragment();

        Bundle bundle = new Bundle();

        return cdf;
    }
}
