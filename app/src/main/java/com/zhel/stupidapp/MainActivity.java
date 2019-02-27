package com.zhel.stupidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int leftRandomFigure = 0;
    private int rightRandomFigure = 0;

    private int points = 0;

    TextView pointsText;
    private TextView leftFigureText;
    private TextView rightFigureText;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        leftFigureText = findViewById(R.id.leftFigure);
        rightFigureText = findViewById(R.id.rightFigure);
        pointsText = findViewById(R.id.points);

        randomFigures();
    }

    public void randomFigures() {
        leftRandomFigure = random.nextInt(20);
        rightRandomFigure = random.nextInt(20);

        leftFigureText.setText(String.valueOf(leftRandomFigure));
        rightFigureText.setText(String.valueOf(rightRandomFigure));
    }

    public void onLeftClick(View v) {
        if (leftRandomFigure >= rightRandomFigure) {
            points++;
            pointsText.setText(String.format("Points: %s", String.valueOf(points)));
            Toast toast = Toast.makeText(this, "+1. You right!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            points--;
            pointsText.setText(String.format("Points: %s", String.valueOf(points)));
            Toast toast = Toast.makeText(this, "-1. You lose!", Toast.LENGTH_SHORT);
            toast.show();
        }
        randomFigures();
    }

    public void onRightClick(View v) {
        if (rightRandomFigure >= leftRandomFigure) {
            points++;
            pointsText.setText(String.format("Points: %s", String.valueOf(points)));
            Toast toast = Toast.makeText(this, "+1. You right!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            points--;
            pointsText.setText(String.format("Points: %s", String.valueOf(points)));
            Toast toast = Toast.makeText(this, "-1. You lose!", Toast.LENGTH_SHORT);
            toast.show();
        }
        randomFigures();
    }
}
