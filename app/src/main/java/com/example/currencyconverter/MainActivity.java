package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_1st_amount)
    EditText edt1stAmount;
    @BindView(R.id.edt_2nd_amount)
    EditText edt2ndAmount;
    @BindView(R.id.img_1st_down_arrow)
    ImageView img1stDownArrow;
    @BindView(R.id.img_2nd_down_arrow)
    ImageView img2ndDownArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        img1stDownArrow.setOnClickListener(v -> {
            Toast.makeText(this, "this is first block", Toast.LENGTH_SHORT).show();
        });

        img2ndDownArrow.setOnClickListener(v -> {
            Toast.makeText(this, "this is second block", Toast.LENGTH_SHORT).show();

        });
    }
}