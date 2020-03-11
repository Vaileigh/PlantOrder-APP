package com.example.plant_order;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
//    public static
    public static final String EXTRA_MESSAGE = "com.example.plant_order.extra.MESSAGE";
//    private int
    private int totalQty = 0;
    private int intQty1 = 0;
    private int intQty2 = 0;
    private int intQty3 = 0;
    private int intQty4 = 0;
    private int priceQty1 = 33;
    private int priceQty2 = 15;
    private int priceQty3 = 25;
    private int priceQty4 = 39;
    private int subtotal = 0;
//    private String
    private String show_id;
//    private TextView
    private TextView totalSelected;
    private TextView subtotalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        qty1 = (TextView) findViewById(R.id.quantity1);
        totalSelected = (TextView) findViewById(R.id.textView_itemSelected);
        subtotalPrice = (TextView) findViewById(R.id.textView_pricesubtotal);
        setSupportActionBar(toolbar);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }



    public void checkOut(View view) {
        Intent thirdIntent = new Intent(Second.this, Third.class);
        String subtotal_String = subtotalPrice.getText().toString();
        thirdIntent.putExtra(EXTRA_MESSAGE, subtotal_String);
        startActivity(thirdIntent);
    }
    public void validateId(View view){
        switch(view.getId()) {
            case R.id.plus1:
                show_id = "quantity1";
                plusInc();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.minus1:
                show_id = "quantity1";
                minusDec();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.plus2:
                show_id = "quantity2";
                plusInc();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.minus2:
                show_id = "quantity2";
                minusDec();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.plus3:
                show_id = "quantity3";
                plusInc();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.minus3:
                show_id = "quantity3";
                minusDec();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.plus4:
                show_id = "quantity4";
                plusInc();
                calculateSubtotal();
                updateInt(show_id);
                break;
            case R.id.minus4:
                show_id = "quantity4";
                minusDec();
                calculateSubtotal();
                updateInt(show_id);
                break;
        }
    }
    public void calculateSubtotal(){
        subtotal = priceQty1*intQty1+priceQty2*intQty2+priceQty3*intQty3+priceQty4*intQty4;
    }
    public void plusInc() {
        if(show_id == "quantity1")
            ++intQty1;
        else if (show_id == "quantity2")
            ++intQty2;
        else if (show_id == "quantity3")
            ++intQty3;
        else if (show_id == "quantity4")
            ++intQty4;
        ++totalQty;
    }

    public void minusDec() {
        if(show_id == "quantity1"){
            if(intQty1 > 0){
                --intQty1;
                --totalQty;
            }
        }
        else if (show_id == "quantity2"){
            if(intQty2 > 0){
                --intQty2;
                --totalQty;
            }
        }

        else if (show_id == "quantity3"){
            if(intQty3 > 0){
                --intQty3;
                --totalQty;
            }
        }

        else if (show_id == "quantity4"){
            if(intQty4 > 0){
                --intQty4;
                --totalQty;
            }
        }

    }

    public void updateInt(String show_id){
        int resID = getResources().getIdentifier(show_id,"id",getPackageName());
        TextView field_id;
        field_id = (TextView) findViewById(resID);

        if(show_id == "quantity1")
            field_id.setText(Integer.toString(intQty1));
        else if (show_id == "quantity2")
            field_id.setText(Integer.toString(intQty2));

        else if (show_id == "quantity3")
            field_id.setText(Integer.toString(intQty3));

        else if (show_id == "quantity4")
            field_id.setText(Integer.toString(intQty4));

        totalSelected.setText("[ "+Integer.toString(totalQty)+" Item Selected ]");
        subtotalPrice.setText("$ "+Integer.toString(subtotal)+".00 ");
    }
    public void snakeplant(View view) {
        displayToast(getString(R.string.snake_plant_message));
    }

    public void pothos(View view) {
        displayToast(getString(R.string.pothos_message));
    }

    public void dracaena(View view) {
        displayToast(getString(R.string.dracaena_message));
    }

    public void philodendrongreen(View view) {
        displayToast(getString(R.string.philodendron_green_message));
    }
}
