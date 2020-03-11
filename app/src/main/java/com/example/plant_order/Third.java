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

    private double shipFees;
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
    private void shippingSubtotal(String shipMethod){
        String snippingChoices[]= getResources().getStringArray(R.array.labels_array);
        if(shipMethod.equals(snippingChoices[0]))
            shipFees =3.65;
        else if(shipMethod.equals(snippingChoices[1]))
            shipFees =5.53;
        else if (shipMethod.equals(snippingChoices[2]))
            shipFees =2.46;
        TextView shipTotal;
        shipTotal = (TextView) findViewById(R.id.textView_priceProd2);
//        Toast.makeText(this, Double.toString(shipFees),
//                Toast.LENGTH_SHORT).show();
        shipTotal.setText("$ "+Double.toString(shipFees));
    }

    @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int
                i, long l) {
            String spinnerLabel = adapterView.getItemAtPosition(i).toString();
            shippingSubtotal(spinnerLabel);
            displayToast(spinnerLabel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

