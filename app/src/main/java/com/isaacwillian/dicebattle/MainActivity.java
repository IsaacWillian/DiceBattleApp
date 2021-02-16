package com.isaacwillian.dicebattle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
;

public class MainActivity extends AppCompatActivity {

    public Integer points1 = 0;
    public Integer points2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void updatePoints(){
        TextView player1points = findViewById(R.id.pointsPlayer1);
        TextView player2points = findViewById(R.id.pointsPlayer2);
        player1points.setText(points1.toString());
        player2points.setText(points2.toString());

    }

    public boolean checkVictory(Integer points1, Integer points2){
        if (points1 == 10 || points2 == 10){

            if (points1 == 10){
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.view), R.string.player1Victory, Snackbar.LENGTH_SHORT );
                mySnackbar.show();
            }
            else{
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.view), R.string.player2Victory, Snackbar.LENGTH_SHORT );
                mySnackbar.show();

            }

            return true;

        }
        else{
            return false;
        }

    }

    public void rollDice(View view){
        Random rand = new Random();

        Integer number1 = rand.nextInt(6)+1;
        Integer number2 = rand.nextInt(6)+1;


        TextView numberDice1 = findViewById(R.id.numberDice1);
        TextView numberDice2 = findViewById(R.id.numberDice2);

        numberDice1.setText(number1.toString());
        numberDice2.setText(number2.toString());


        if (number1 > number2){
            points1++;

        }
        else {
            if (number1 == number2) {
                return;
            } else {
                points2++;
            }
        }
        boolean win = checkVictory(points1,points2);
        if (win){
            points1 = 0;
            points2 = 0;
        }

        updatePoints();






    }

}