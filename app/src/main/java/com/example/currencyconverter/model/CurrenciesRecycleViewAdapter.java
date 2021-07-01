package com.example.currencyconverter.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;
import com.example.currencyconverter.model2.CurrencyCountry;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrenciesRecycleViewAdapter extends RecyclerView.Adapter<CurrenciesRecycleViewAdapter.ViewHolder> {

    private List<CurrencyCountry> currencyCountryList;
    private boolean btn;
    private CallBack callBack;
    private CancelCallBack cancelCallBack;

    public CurrenciesRecycleViewAdapter(CallBack callBack, CancelCallBack cancelCallBack,
                                        List<CurrencyCountry> currencyCountryList, boolean btn) {
        this.callBack = callBack;
        this.currencyCountryList = currencyCountryList;
        this.cancelCallBack = cancelCallBack;
        this.btn = btn;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_currencies, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CurrencyCountry current = currencyCountryList.get(position);

        holder.txtCurrencyId.setText(current.getCurrencyId());
        holder.txtCurrencyName.setText(current.getCurrencyName());

        holder.llCurrencyName.setOnClickListener(v -> {

            if (btn) {
                Log.d("tag", "onBindViewHolder: " + btn);
                callBack.onClickFirst(current.getCurrencyId(), current.getCurrencySymbol());
            } else {
                callBack.onClickSecond(current.getCurrencyId(), current.getCurrencySymbol());
            }

            //To Cancel Dialog fragment
            cancelCallBack.onSelectCountry();
        });

    }

    @Override
    public int getItemCount() {
        return currencyCountryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_currency_name)
        LinearLayout llCurrencyName;
        @BindView(R.id.txt_currency_name)
        TextView txtCurrencyName;
        @BindView(R.id.txt_currency_id)
        TextView txtCurrencyId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CallBack {

        void onClickFirst(String currId, String currSymbol);

        void onClickSecond(String currId, String currSymbol);
    }

    public interface CancelCallBack {
        void onSelectCountry();
    }

}
