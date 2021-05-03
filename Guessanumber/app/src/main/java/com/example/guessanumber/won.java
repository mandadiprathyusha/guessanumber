package com.example.guessanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class won extends AppCompatActivity {

    TextView congo;
    Button btnplayagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        congo=findViewById(R.id.congo);
        btnplayagain=findViewById(R.id.btnplayagain);
        final String pname = getIntent().getStringExtra("pname");
        congo.setText("Congratulations "+pname +"\n you won!!");

        btnplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(won.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}