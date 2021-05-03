package com.example.guessanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    EditText entername;
    Button btnstart;
    Button rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome =findViewById(R.id.welcome);
        entername = findViewById(R.id.entername);
        btnstart=findViewById(R.id.btnstart);
        rules= findViewById(R.id.btnrules);


        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(entername.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all feilds",Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = entername.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,Game.class);
                    intent.putExtra("playername",name);
                    startActivity(intent);
                }
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Rules.class);
                startActivity(intent);
            }
        });


    }
}