package com.example.plant_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Third extends AppCompatActivity implements
    AdapterView.OnItemSelectedListener {

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

       // private Intent secondIntent = getIntent();
     //   private String string_subtotal = secondIntent.getStringExtra(Second.EXTRA_MESSAGE);
      //  private int int_subtotal = Integer.parseInt(string_subtotal);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third);
            Intent secondIntent = getIntent();
            String string_subtotal = secondIntent.getStringExtra(Second.EXTRA_MESSAGE);
            int[] products = secondIntent.getIntArrayExtra(Second.EXTRA_PRODUCT);
            productSubtotal(products[4]);
//            String int_subtotal = Integer.toString(products[4]);
//            Toast.makeText(this, int_subtotal,
//                Toast.LENGTH_SHORT).show();
            Spinner spinner = findViewById(R.id.label_spinner);
            if (spinner != null) {
                spinner.setOnItemSelectedListener(this);
            }
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.labels_array, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);

            if (spinner != null) {
                spinner.setAdapter(adapter);
            }
        }

    private void productSubtotal(int price) {
        TextView subtotal;
        subtotal = (TextView) findViewById(R.id.textView_priceProd);
        subtotal.setText("$ "+Integer.toString(price)+".00");
    }

    @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int
                i, long l) {
            String spinnerLabel = adapterView.getItemAtPosition(i).toString();
           // displayToast(spinnerLabel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

