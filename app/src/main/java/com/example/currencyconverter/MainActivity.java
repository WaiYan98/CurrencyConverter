package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.currencyconverter.model.CurrencyDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_1st_amount)
    EditText edt1stAmount;
    @BindView(R.id.edt_2nd_amount)
    EditText edt2ndAmount;
    @BindView(R.id.img_1st_currency)
    ImageView img1stCurrency;
    @BindView(R.id.img_2nd_currency)
    ImageView img2ndCurrency;
    private CurrencyDialogFragment cdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        cdf = CurrencyDialogFragment.getNewInstance();

        img1stCurrency.setOnClickListener(v -> {

            cdf.show(getSupportFragmentManager(), "");

        });

        img2ndCurrency.setOnClickListener(v -> {

            cdf.show(getSupportFragmentManager(), "");

        });
    }
}