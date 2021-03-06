package com.example.currencyconverter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.currencyconverter.model.CurrenciesRecycleViewAdapter;
import com.example.currencyconverter.model.CurrencyDialogFragment;
import com.example.currencyconverter.model2.CurrencyCountry;
import com.example.currencyconverter.util.InitList;
import com.example.currencyconverter.util.SortingNames;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CurrenciesRecycleViewAdapter.CallBack {

    @BindView(R.id.txt_1st_symbol)
    TextView txt1stSymbol;
    @BindView(R.id.txt_2nd_symbol)
    TextView txt2ndSymbol;
    @BindView(R.id.edt_1st_amount)
    EditText edt1stAmount;
    @BindView(R.id.edt_2nd_amount)
    EditText edt2ndAmount;
    @BindView(R.id.txt_1st_currency_name)
    TextView txt1stCurrencyName;
    @BindView(R.id.txt_2nd_currency_name)
    TextView txt2ndCurrencyName;
    @BindView(R.id.img_1st_currency)
    ImageView img1stCurrency;
    @BindView(R.id.img_2nd_currency)
    ImageView img2ndCurrency;
    @BindView(R.id.ll_view)
    LinearLayout llView;
    @BindView(R.id.lottie_loading)
    LottieAnimationView lottieLoading;
    private InitList initList;
    private boolean btn;
    private List<CurrencyCountry> currencyCountryList;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initList = new InitList();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free.currconv.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        CurrencyService cs = retrofit.create(CurrencyService.class);

        Disposable disposable = cs.getAllCurrencyCountriesData()
                .doOnSubscribe(disposable1 -> {
                    llView.setVisibility(View.GONE);
                    lottieLoading.setVisibility(View.VISIBLE);

                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(currencyCountriesData -> {

                    lottieLoading.setVisibility(View.GONE);
                    llView.setVisibility(View.VISIBLE);

                    initList.initList(currencyCountriesData.getResults());
                    currencyCountryList = SortingNames.sorting(initList.getCurrencyCountryList());

                }, error -> Log.d("tag", "onCreate: " + error.getMessage()));


        img1stCurrency.setOnClickListener(v -> {
            btn = true;
            showDialog();
        });

        img2ndCurrency.setOnClickListener(v -> {
            btn = false;
            showDialog();
        });
    }


    @Override
    public void onClickFirst(String currId, String currSymbol) {
        txt1stCurrencyName.setText(currId);
        txt1stSymbol.setText(currSymbol);
    }

    @Override
    public void onClickSecond(String currId, String currSymbol) {
        txt2ndCurrencyName.setText(currId);
        txt2ndSymbol.setText(currSymbol);
    }

    //To show Dialog Fragment
    public void showDialog() {

        CurrencyDialogFragment cdf = CurrencyDialogFragment.getNewInstance(CurrencyDialogFragment.KEY1, btn,
                CurrencyDialogFragment.KEY2, currencyCountryList);
        cdf.show(getSupportFragmentManager(), "");
    }
}