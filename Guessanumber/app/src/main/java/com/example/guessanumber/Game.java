package com.example.guessanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {
    TextView hey;
    EditText enternum;
    Button btncheck;
    TextView range;
    TextView chances;
    Random r = new Random();
    int num = r.nextInt(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        hey = findViewById(R.id.hey);
        enternum = findViewById(R.id.enternum);
        btncheck = findViewById(R.id.btncheck);
        range = findViewById(R.id.range);
        chances = findViewById(R.id.chances);

        final String playername = getIntent().getStringExtra("playername");
        hey.setText("Hey!!!"+playername+"\n"+"Lets start the game");
        Random r = new Random();
        final int num = r.nextInt(100);
        range.setVisibility(View.GONE);
        chances.setVisibility(View.GONE);
        final int[] c = {5};
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (enternum.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Game.this, "Please enter all feilds", Toast.LENGTH_SHORT).show();
                } else {
                        int n = Integer.parseInt(enternum.getText().toString().trim());
                        if (num == n) {
                            Intent intent = new Intent(Game.this, won.class);
                            intent.putExtra("pname",playername);
                            startActivity(intent);
                        } else {
                            c[0] = c[0] -1;
                            chances.setVisibility(View.VISIBLE);
                            chances.setText("chance number: "+ c[0]);
                            if(c[0] <=0){
                                Intent intent = new Intent(Game.this, lost.class);
                                intent.putExtra("pname",playername);
                                startActivity(intent);
                            }
                            if (n > num) {
                                range.setVisibility(View.VISIBLE);
                                range.setText("your guess is wrong.Try a lower number");
                            } else {
                                range.setVisibility(View.VISIBLE);
                                range.setText("your guess is wrong.Try a higher number");
                            }
                        }

                }
            }
            });
    }
}