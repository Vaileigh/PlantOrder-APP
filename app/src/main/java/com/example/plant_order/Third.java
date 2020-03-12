package com.example.plant_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Third extends AppCompatActivity implements
    AdapterView.OnItemSelectedListener {
    private LinearLayout prod1;
    private LinearLayout rowLink;
    private LayoutInflater layoutInflater;
    private double shipFees;
    private int product;
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

            checkProduct(products);

            //Product subtotal
            product = products[4];
            productSubtotal(product);


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


    private void checkProduct(int[] product){
//        for(int i=0; i<4;i++){
            if(product[0]>0){
                rowLink = (LinearLayout)getLayoutInflater().inflate(R.layout.product1, null);
                TextView firstProductQty = (TextView)rowLink.findViewById(R.id.textQuantityProd1);
                firstProductQty.setText ("100");
                prod1 = findViewById(R.id.thirdPage);
                layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View myview = layoutInflater.inflate(R.layout.product1, null, false);
                prod1.addView(myview);
                }
            if(product[1]>0){
                rowLink = (LinearLayout)getLayoutInflater().inflate(R.layout.product1, null);
                TextView firstProductQty = (TextView)rowLink.findViewById(R.id.textQuantityProd1);
                firstProductQty.setText ("100");
                prod1 = findViewById(R.id.thirdPage);
                layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View myview = layoutInflater.inflate(R.layout.product2, null, false);
                prod1.addView(myview);
            }if(product[2]>0){
                rowLink = (LinearLayout)getLayoutInflater().inflate(R.layout.product1, null);
                TextView firstProductQty = (TextView)rowLink.findViewById(R.id.textQuantityProd1);
                firstProductQty.setText ("100");
                prod1 = findViewById(R.id.thirdPage);
                layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View myview = layoutInflater.inflate(R.layout.product3, null, false);
                prod1.addView(myview);
            }if(product[3]>0){
                rowLink = (LinearLayout)getLayoutInflater().inflate(R.layout.product1, null);
                TextView firstProductQty = (TextView)rowLink.findViewById(R.id.textQuantityProd1);
                firstProductQty.setText ("100");
                prod1 = findViewById(R.id.thirdPage);
                layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View myview = layoutInflater.inflate(R.layout.product4, null, false);
                prod1.addView(myview);
            }
//        }
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

    private void totalPayment(){
//        double prodSubtotal = product;
        double sum = product + shipFees;
        TextView paymentView;
        paymentView = (TextView) findViewById(R.id.total);
        paymentView.setText ("$ "+Double.toString(sum));
    }

    @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int
                i, long l) {
            String spinnerLabel = adapterView.getItemAtPosition(i).toString();
            shippingSubtotal(spinnerLabel);
            totalPayment();
            displayToast(spinnerLabel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

