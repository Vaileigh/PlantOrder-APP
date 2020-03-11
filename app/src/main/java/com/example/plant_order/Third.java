package com.example.plant_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Third extends AppCompatActivity {
    private Intent secondIntent = getIntent();
    private String string_subtotal = secondIntent.getStringExtra (Second.EXTRA_MESSAGE);
    private int int_subtotal = Integer.parseInt(string_subtotal);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
}
