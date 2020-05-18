package com.yash.spider_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p1_name, p2_name, number_of_rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1_name = findViewById(R.id.et_p1_name);
        p2_name = findViewById(R.id.et_p2_name);
        number_of_rounds = findViewById(R.id.et_number_of_rounds);
    }

    public void start(View view) {
        try {


            Intent intent = new Intent(MainActivity.this, player.class);
            if (p1_name.getText().toString().equals("")) {
                Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
                p1_name.setError("please give player-1 name");
                if (p2_name.getText().toString().equals("")) {
                    p2_name.setError("please give player-2 name");
                }
                if (number_of_rounds.getText().toString().equals("")) {
                    number_of_rounds.setError("please give number of rounds");
                }
            } else if (p2_name.getText().toString().equals("")) {
                Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
                p2_name.setError("please give player-2 name");
                if (number_of_rounds.getText().toString().equals("")) {
                    number_of_rounds.setError("please give number of rounds");
                }
            } else {
                intent.putExtra("player_1_name", (p1_name).getText().toString());
                intent.putExtra("player_2_name", (p2_name).getText().toString());
                intent.putExtra("number_of_rounds", Integer.parseInt((number_of_rounds).getText().toString()));
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
            if (p1_name.getText().toString().equals("")) {
                p1_name.setError("please give player-1 name");
            }
            if (p2_name.getText().toString().equals("")) {
                p2_name.setError("please give player-1 name");
            }
            if (number_of_rounds.getText().toString().equals("")) {
                number_of_rounds.setError("please give number of rounds");
            }
        }
    }


    public void Computer(View view) {
        try {
            if (p1_name.getText().toString().equals("")) {
                Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
                p1_name.setError("please give player-1 name");
                if (number_of_rounds.getText().toString().equals("")) {
                    number_of_rounds.setError("please give number of rounds");
                }
            } else if (number_of_rounds.getText().toString().equals("")) {
                Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
                number_of_rounds.setError("please give number of rounds");
            } else {
                Intent intent = new Intent(MainActivity.this, computer.class);
                intent.putExtra("player_1_name", (p1_name).getText().toString());
                intent.putExtra("number_of_rounds", Integer.parseInt((number_of_rounds).getText().toString()));
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "PLEASE FILL THE REQUIRED DETAILS", Toast.LENGTH_SHORT).show();
            if (p1_name.getText().toString().equals("")) {
                p1_name.setError("please give player name");
            }
        }
    }
}
