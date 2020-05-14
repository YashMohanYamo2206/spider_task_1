package com.yash.spider_task_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class computer extends AppCompatActivity {
    TextView p1_name, rounds, p1Win, p2Win;
    String p1Name;
    int number_of_rounds, p1Choice, p2Choice = 1, p1_win = 0, p2_win = 0;
    ImageView p1_choice, p2_choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        p1_name = findViewById(R.id.player_1_name);
        rounds = findViewById(R.id.tv_rounds_left);
        Intent intent = getIntent();
        p1Name = intent.getStringExtra("player_1_name");
        number_of_rounds = intent.getIntExtra("number_of_rounds", 5);
        instruction();
        p1_choice = findViewById(R.id.player_1_choice);
        p2_choice = findViewById(R.id.player_2_choice);
        p1Win = findViewById(R.id.tv_p1_win);
        p2Win = findViewById(R.id.tv_p2_win);
    }

    public void p1_selected_btn(View v) {
        switch (v.getId()) {
            case R.id.p1_btn_paper:
                p1_choice.setImageResource(R.drawable.paper);
                p1Choice = 0;
                p2_selected_btn();
                break;
            case R.id.p1_btn_scissors:
                p1_choice.setImageResource(R.drawable.scissors);
                p1Choice = 1;
                p2_selected_btn();
                break;
            case R.id.p1_btn_stone:
                p1_choice.setImageResource(R.drawable.stone);
                p1Choice = 2;
                p2_selected_btn();
                break;
        }
    }

    public void p2_selected_btn() {
        Random computer_choice = new Random();
        p2Choice = computer_choice.nextInt(2);
        switch (p2Choice) {
            case 0:
                p2_choice.setImageResource(R.drawable.paper);
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
            case 1:
                p2_choice.setImageResource(R.drawable.scissors);
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
            case 2:
                p2_choice.setImageResource(R.drawable.stone);
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
        }

    }

    private void checkwinner() {
        if (number_of_rounds >= 0) {

            if (p1Choice == 0 && p2Choice == 2) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            } else if (p1Choice == 0 && p2Choice == 1) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            } else if (p1Choice == 1 && p2Choice == 0) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            } else if (p1Choice == 1 && p2Choice == 2) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            } else if (p1Choice == 2 && p2Choice == 1) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            } else if (p1Choice == 2 && p2Choice == 0) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            }
        } else {
            String winner = "";
            if (p1_win > p2_win) {
                winner = p1Name + " wins...!!!!";
            } else if (p2_win > p1_win) {
                winner = "COMPUTER wins...!!!!";
            } else {
                winner = "DRAW..!!!";
            }
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(winner);
            dialog.setTitle("WINNER");
            dialog.setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(computer.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                }
            });
            dialog.setNegativeButton("QUIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = dialog.create();
            alertDialog.setCancelable(false);
            alertDialog.show();
        }
    }

    public void instruction() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("1.) " + p1Name + " starts the game\n\n\n" +
                "2.) " + "COMPUTER" + " then chooses their option\n\n\n" +
                "3.) winner takes all\n\n\n\n" +
                "Enjoy ..!!");
        dialog.setTitle("INSTRUCTION");
        dialog.setPositiveButton("GOTCHA.!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                p1_name.setText(p1Name);
                rounds.setText(String.valueOf(number_of_rounds));
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}
