package com.example.freedompaychallenge;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;
import android.widget.Button;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private int num = 0;
    private TextView textbox;
    private Button button;
    private Button resetbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        textbox = findViewById(R.id.textbox);
        button = findViewById(R.id.addbutton);
        resetbutton = findViewById(R.id.resetbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                textbox.setText("Count: " + num);
                if(num >= 10) {
                    textbox.setTextColor(Color.RED);
                }
            }
        });
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textbox.setText("Count: 0");
                if(num >= 10) {
                    textbox.setTextColor(Color.BLACK);
                }
                num = 0;
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("num", num);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num = savedInstanceState.getInt("num");
        textbox.setText("Count: " + num);
        if(num >= 10) {
            textbox.setTextColor(Color.RED);
        }
    }
}