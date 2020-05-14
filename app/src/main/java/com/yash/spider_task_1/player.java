package com.yash.spider_task_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class player extends AppCompatActivity {
    TextView p1_name, p2_name, rounds, p1Win, p2Win;
    String p1Name, p2Name;
    int number_of_rounds, p1Choice, p2Choice, p1_win = 0, p2_win = 0;
    ImageView p1_choice, p2_choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        p1_name = findViewById(R.id.player_1_name);
        p2_name = findViewById(R.id.player_2_name);
        rounds = findViewById(R.id.tv_rounds_left);
        Intent intent = getIntent();
        p1Name = intent.getStringExtra("player_1_name");
        p2Name = intent.getStringExtra("player_2_name");
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
                p1Choice = 1;
                break;
            case R.id.p1_btn_scissors:
                p1_choice.setImageResource(R.drawable.scissors);
                p1Choice = 2;
                break;
            case R.id.p1_btn_stone:
                p1_choice.setImageResource(R.drawable.stone);
                p1Choice = 3;
                break;
        }
    }

    public void p2_selected_btn(View view) {
        switch (view.getId()) {
            case R.id.p2_btn_paper:
                p2_choice.setImageResource(R.drawable.paper);
                p2Choice = 1;
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
            case R.id.p2_btn_scissors:
                p2_choice.setImageResource(R.drawable.scissors);
                p2Choice = 2;
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
            case R.id.p2_btn_stone:
                p2_choice.setImageResource(R.drawable.stone);
                p2Choice = 3;
                number_of_rounds -= 1;
                checkwinner();
                rounds.setText(String.valueOf(number_of_rounds));
                break;
        }
    }

    private void checkwinner() {
        if (number_of_rounds >= 0) {

            if (p1Choice == 1 && p2Choice == 3) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            }
            if (p1Choice == 1 && p2Choice == 2) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            }
            if (p1Choice == 2 && p2Choice == 1) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            }
            if (p1Choice == 2 && p2Choice == 3) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            }
            if (p1Choice == 3 && p2Choice == 2) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
            }
            if (p1Choice == 3 && p2Choice == 1) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
            }
        } else {
            String winner = "";
            if (p1_win > p2_win) {
                winner = p1Name + " wins...!!!!";
            } else if (p2_win > p1_win) {
                winner = p2Name + " wins...!!!!";
            } else {
                winner = "DRAW..!!!";
            }
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(winner);
            dialog.setTitle("WINNER");
            dialog.setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(player.this, MainActivity.class);
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
                "2.) " + p2Name + " then chooses their option\n\n\n" +
                "3.) winner takes all\n\n\n\n" +
                "Enjoy ..!!");
        dialog.setTitle("INSTRUCTION");
        dialog.setPositiveButton("GOTCHA.!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                p1_name.setText(p1Name);
                p2_name.setText(p2Name);
                rounds.setText(String.valueOf(number_of_rounds));
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}
