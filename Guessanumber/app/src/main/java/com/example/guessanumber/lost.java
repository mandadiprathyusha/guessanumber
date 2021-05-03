package com.example.guessanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lost extends AppCompatActivity {

    TextView lost;
    Button btnlost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        lost = findViewById(R.id.lost);
        btnlost=findViewById(R.id.btnlost);
        final String pname = getIntent().getStringExtra("pname");
        lost.setText("Sorry you lost\n"+pname);
        btnlost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lost.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}