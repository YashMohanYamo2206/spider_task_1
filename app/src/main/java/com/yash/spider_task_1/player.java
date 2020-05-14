package com.yash.spider_task_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class player extends AppCompatActivity {
    TextView p1_name, p2_name, rounds, p1Win, p2Win;
    LinearLayout iv, p2, p1;
    String p1Name, p2Name;
    int number_of_rounds, p1Choice, p2Choice, p1_win = 0, p2_win = 0;
    ImageView p1_choice, p2_choice;
    Button p1s, p1st, p1p, p2s, p2st, p2p;

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
        iv = findViewById(R.id.iv);
        p2 = findViewById(R.id.p2_lo);
        p1 = findViewById(R.id.p1_lo);
        p1_win = 0;
        p2_win = 0;
        p1s = findViewById(R.id.p1_btn_scissors);
        p1st = findViewById(R.id.p1_btn_stone);
        p1p = findViewById(R.id.p1_btn_paper);
        p2s = findViewById(R.id.p2_btn_scissors);
        p2st = findViewById(R.id.p2_btn_stone);
        p2p = findViewById(R.id.p2_btn_paper);
    }

    public void p1_selected_btn(View v) {
        switch (v.getId()) {
            case R.id.p1_btn_paper:
                p1_choice.setImageResource(R.drawable.paper);
                p1Choice = 1;
                iv.setVisibility(View.INVISIBLE);
                p2s.setEnabled(true);
                p2st.setEnabled(true);
                p2p.setEnabled(true);
                p1s.setEnabled(false);
                p1st.setEnabled(false);
                p1p.setEnabled(false);
                break;
            case R.id.p1_btn_scissors:
                p1_choice.setImageResource(R.drawable.scissors);
                p1Choice = 2;
                iv.setVisibility(View.INVISIBLE);
                p2s.setEnabled(true);
                p2st.setEnabled(true);
                p2p.setEnabled(true);
                p1s.setEnabled(false);
                p1st.setEnabled(false);
                p1p.setEnabled(false);
                break;
            case R.id.p1_btn_stone:
                p1_choice.setImageResource(R.drawable.stone);
                p1Choice = 3;
                iv.setVisibility(View.INVISIBLE);
                p2s.setEnabled(true);
                p2st.setEnabled(true);
                p2p.setEnabled(true);
                p1s.setEnabled(false);
                p1st.setEnabled(false);
                p1p.setEnabled(false);
                break;
        }
    }

    public void p2_selected_btn(View view) {
        switch (view.getId()) {
            case R.id.p2_btn_paper:
                p2s.setEnabled(false);
                p2st.setEnabled(false);
                p2p.setEnabled(false);
                p1s.setEnabled(true);
                p1st.setEnabled(true);
                p1p.setEnabled(true);
                p2_choice.setImageResource(R.drawable.paper);
                p2Choice = 1;
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    rounds.setText(String.valueOf(number_of_rounds));
                    checkwinner();
                    if (number_of_rounds == 0) {
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
                iv.setVisibility(View.VISIBLE);
                break;
            case R.id.p2_btn_scissors:
                p2s.setEnabled(false);
                p2st.setEnabled(false);
                p2p.setEnabled(false);
                p1s.setEnabled(true);
                p1st.setEnabled(true);
                p1p.setEnabled(true);
                p2_choice.setImageResource(R.drawable.scissors);
                p2Choice = 2;
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    checkwinner();
                    rounds.setText(String.valueOf(number_of_rounds));
                    if (number_of_rounds == 0) {
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
                iv.setVisibility(View.VISIBLE);
                break;
            case R.id.p2_btn_stone:
                p2s.setEnabled(false);
                p2st.setEnabled(false);
                p2p.setEnabled(false);
                p1s.setEnabled(true);
                p1st.setEnabled(true);
                p1p.setEnabled(true);
                p2_choice.setImageResource(R.drawable.stone);
                p2Choice = 3;
                if (number_of_rounds >= 1) {
                    number_of_rounds -= 1;
                    checkwinner();
                    rounds.setText(String.valueOf(number_of_rounds));
                    if (number_of_rounds == 0) {
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
                iv.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void checkwinner() {
        if (number_of_rounds >= 0) {

            if (p1Choice == 1 && p2Choice == 3) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
                Toast.makeText(this, p1Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
            if (p1Choice == 1 && p2Choice == 2) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
                Toast.makeText(this, p2Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
            if (p1Choice == 2 && p2Choice == 1) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
                Toast.makeText(this, p1Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
            if (p1Choice == 2 && p2Choice == 3) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
                Toast.makeText(this, p2Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
            if (p1Choice == 3 && p2Choice == 2) {
                p1_win++;
                p1Win.setText(String.valueOf(p1_win));
                Toast.makeText(this, p1Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
            if (p1Choice == 3 && p2Choice == 1) {
                p2_win++;
                p2Win.setText(String.valueOf(p2_win));
                Toast.makeText(this, p2Name+" wins this round.!!!", Toast.LENGTH_SHORT).show();
            }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle b) {
        super.onSaveInstanceState(b);
        b.putInt("number_of_rounds", number_of_rounds);
        b.putInt("p1_win", p1_win);
        b.putInt("p2_win", p2_win);
        b.putBoolean("p1s", p1s.isEnabled());
        b.putBoolean("p1st", p1st.isEnabled());
        b.putBoolean("p1p", p1p.isEnabled());
        b.putBoolean("p2s", p2s.isEnabled());
        b.putBoolean("p2st", p2st.isEnabled());
        b.putBoolean("p2p", p2p.isEnabled());
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
        p1s.setEnabled(b.getBoolean("p1s"));
        p1st.setEnabled(b.getBoolean("p1st"));
        p1p.setEnabled(b.getBoolean("p1p"));
        p2s.setEnabled(b.getBoolean("p2s"));
        p2st.setEnabled(b.getBoolean("p2st"));
        p2p.setEnabled(b.getBoolean("p2p"));
    }
}
