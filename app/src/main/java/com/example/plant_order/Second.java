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
    private int totalQty = 0;
    private int intQty1 = 0;
    private int intQty2 = 0;
    private int intQty3 = 0;
    private int intQty4 = 0;
    private String show_id;
//    private TextView qty1;
    private TextView totalSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        qty1 = (TextView) findViewById(R.id.quantity1);
        totalSelected = (TextView) findViewById(R.id.textView_itemSelected);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void snakeplant(View view) {
        displayToast(getString(R.string.snake_plant_message));
    }

    public void checkOut(View view) {
        Intent thirdIntent = new Intent(Second.this, Third.class);
        startActivity(thirdIntent);
    }
    public void validateId(View view){
        switch(view.getId()) {
            case R.id.plus1:
                show_id = "quantity1";
                plusInc();
                updateInt(show_id);
                break;
            case R.id.minus1:
                show_id = "quantity1";
                minusDec();
                updateInt(show_id);
                break;
            case R.id.plus2:
                show_id = "quantity2";
                plusInc();
                updateInt(show_id);
                break;
            case R.id.minus2:
                show_id = "quantity2";
                minusDec();
                updateInt(show_id);
                break;
            case R.id.plus3:
                show_id = "quantity3";
                plusInc();
                updateInt(show_id);
                break;
            case R.id.minus3:
                show_id = "quantity3";
                minusDec();
                updateInt(show_id);
                break;
            case R.id.plus4:
                show_id = "quantity4";
                plusInc();
                updateInt(show_id);
                break;
            case R.id.minus4:
                show_id = "quantity4";
                minusDec();
                updateInt(show_id);
                break;
        }
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
    }
}
