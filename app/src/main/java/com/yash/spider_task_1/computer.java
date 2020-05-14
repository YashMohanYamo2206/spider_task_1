package com.yash.spider_task_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Random;

public class computer extends AppCompatActivity {
    TextView p1_name, rounds, p1Win, p2Win;
    String p1Name;
    int number_of_rounds, p1Choice, p2Choice = 1, p1_win = 0, p2_win = 0;
    ImageView p1_choice, p2_choice;
    Random computer_choice = new Random();
    RelativeLayout rl;

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
        p2Win = findViewById(R.id.tv_computer_win);
        rl = findViewById(R.id.rl);
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
        int choice = computer_choice.nextInt(3);
        p2Choice = choice;
        switch (choice) {
            case 0:
                p2_choice.setImageResource(R.drawable.paper);
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    rounds.setText(String.valueOf(number_of_rounds));
                    checkwinner();
                    if (number_of_rounds == 0) {
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
                break;
            case 1:
                p2_choice.setImageResource(R.drawable.scissors);
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    rounds.setText(String.valueOf(number_of_rounds));
                    checkwinner();
                    if (number_of_rounds == 0) {
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
                break;
            case 2:
                p2_choice.setImageResource(R.drawable.stone);
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    rounds.setText(String.valueOf(number_of_rounds));
                    checkwinner();
                    if (number_of_rounds == 0) {
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
                break;
        }

    }

    private void checkwinner() {
        if (number_of_rounds >= 0) {

            if (p1Choice == 0 && p2Choice == 2) {
                p1_win++;
                int c = p1_win;
                p1Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.GREEN);
            } else if (p1Choice == 0 && p2Choice == 1) {
                p2_win++;
                int c = p2_win;
                p2Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.RED);
            } else if (p1Choice == 1 && p2Choice == 0) {
                p1_win++;
                int c = p1_win;
                p1Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.GREEN);
            } else if (p1Choice == 1 && p2Choice == 2) {
                p2_win++;
                int c = p2_win;
                p2Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.RED);
            } else if (p1Choice == 2 && p2Choice == 1) {
                p1_win++;
                int c = p1_win;
                p1Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.GREEN);
            } else if (p1Choice == 2 && p2Choice == 0) {
                p2_win++;
                int c = p2_win;
                p2Win.setText(String.valueOf(c));
                rl.setBackgroundColor(Color.RED);
            }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle b) {
        super.onSaveInstanceState(b);
        try {
            ColorDrawable color = (ColorDrawable) rl.getBackground();
            int colorid = color.getColor();
            b.putInt("number_of_rounds", number_of_rounds);
            b.putInt("p1_win", p1_win);
            b.putInt("p2_win", p2_win);
            b.putInt("bg_color", colorid);
        } catch (Exception e) {
            b.putInt("number_of_rounds", number_of_rounds);
            b.putInt("p1_win", p1_win);
            b.putInt("p2_win", p2_win);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle b) {
        super.onRestoreInstanceState(b);
        number_of_rounds = b.getInt("number_of_rounds");
        p1_win = b.getInt("p1_win");
        p2_win = b.getInt("p2_win");
        p1Win.setText(String.valueOf(p1_win));
        p2Win.setText(String.valueOf(p2_win));
        rounds.setText(String.valueOf(number_of_rounds));
        rl.setBackgroundColor(b.getInt("bg_color"));
    }
}
