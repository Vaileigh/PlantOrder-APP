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
    private TextView qty1;
    private TextView totalSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        qty1 = (TextView) findViewById(R.id.quantity1);
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

    public void plus1Inc(View view) {
        ++intQty1;
        ++totalQty;
        updateInt();
    }

    public void minus1Dec(View view) {
        if(intQty1 > 0){
            --intQty1;
            --totalQty;
            updateInt();
        }
    }

    public void updateInt(){
        qty1.setText(Integer.toString(intQty1));
        totalSelected.setText("[ "+Integer.toString(totalQty)+" Item Selected ]");
    }
}
