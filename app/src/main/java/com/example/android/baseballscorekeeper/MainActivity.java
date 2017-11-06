package com.example.android.baseballscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Tracks the score for Team A
    private int scoreTeamA = 0;

    // Tracks the score for Team B
    private int scoreTeamB = 0;

    // The number of balls
    private int balls = 0;

    // The number of strikes
    private int strikes = 0;

    // The number of outs
    private int outs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 points.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the number of balls by 1. If the number of balls is four, the number of strikes become zero.
     */
    public void addOneForBall(View v) {
        balls = balls + 1;
        if (balls == 4) {
            balls = 0;
            strikes = 0;
            displayForStrike(strikes);
        }
        displayForBall(balls);
    }

    /**
     * Increase the number of strikes by 1. If the number of strikes is three, the number of strikes and
     * the number of balls become zero and increase the number of outs by 1.
     */
    public void addOneForStrike(View v) {
        strikes = strikes + 1;
        if (strikes == 3){
            strikes = 0;
            balls = 0;
            displayForBall(balls);
            addOneForOut(findViewById(R.id.out));
        }
        displayForStrike(strikes);
    }

    /**
     * Increase the number of outs by 1.
     * The number of balls and the number of strikes become zero.
     * If the number of outs is three, the number of outs become zero.
     *
     */
    public void addOneForOut(View v) {
        outs = outs + 1;
        if (outs == 3) {
            outs = 0;
        }
        balls = 0;
        strikes = 0;
        displayForBall(balls);
        displayForStrike(strikes);
        displayForOut(outs);
    }

    /**
     * Reset the score for both teams back to 0.
     * Reset the number of balls, strikes and outs back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        balls = 0;
        strikes = 0;
        outs = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForBall(balls);
        displayForStrike(strikes);
        displayForOut(outs);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of balls.
     */
    public void displayForBall(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ball);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of strikes.
     */
    public void displayForStrike(int score) {
        TextView scoreView = (TextView) findViewById(R.id.strike);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display the number of outs.
     */
    public void displayForOut(int score) {
        TextView scoreView = (TextView) findViewById(R.id.out);
        scoreView.setText(String.valueOf(score));
    }
}
