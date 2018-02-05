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

    // TextView that displays Team A score
    private TextView mTeamAScoreView;

    // TextView that displays Team B score
    private TextView mTeamBScoreView;

    // TextView that displays the number of balls
    private TextView mBallView;

    // TextView that displays the number of strikes
    private TextView mStrikeView;

    // TextView that displays the number of outs
    private TextView mOutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamAScoreView = findViewById(R.id.team_a_score);
        mTeamBScoreView = findViewById(R.id.team_b_score);
        mBallView = findViewById(R.id.ball);
        mStrikeView = findViewById(R.id.strike);
        mOutView = findViewById(R.id.out);

    }

    /**
     * Increase the right score for the Team by checking the id of the view passed as a parameter.
     */
    public void addPoint(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add_one_team_a:
                // Increase the score for Team A by 1 points.
                scoreTeamA = scoreTeamA + 1;
                display(mTeamAScoreView, scoreTeamA);
                break;
            case R.id.add_two_team_a:
                // Increase the score for Team A by 2 points.
                scoreTeamA = scoreTeamA + 2;
                display(mTeamAScoreView, scoreTeamA);
                break;
            case R.id.add_one_team_b:
                // Increase the score for Team B by 1 points.
                scoreTeamB = scoreTeamB + 1;
                display(mTeamBScoreView, scoreTeamB);
                break;
            case R.id.add_two_team_b:
                //Increase the score for Team B by 2 points.
                scoreTeamB = scoreTeamB + 2;
                display(mTeamBScoreView, scoreTeamB);
                break;
        }
    }

    /**
     * Increase the number of balls by 1. If the number of balls is four, the number of strikes become zero.
     */
    public void addOneForBall(View v) {
        balls = balls + 1;
        if (balls == 4) {
            balls = 0;
            strikes = 0;
            display(mStrikeView, strikes);
        }
        display(mBallView, balls);
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
            display(mBallView, balls);
            addOneForOut(findViewById(R.id.out));
        }
        display(mStrikeView, strikes);
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
        display(mBallView, balls);
        display(mStrikeView, strikes);
        display(mOutView, outs);
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
        display(mTeamAScoreView, scoreTeamA);
        display(mTeamBScoreView, scoreTeamB);
        display(mBallView, balls);
        display(mStrikeView, strikes);
        display(mOutView, outs);
    }

    /**
     * Displays the score on scoreView
     */
    public void display(TextView scoreView, int score) {
        scoreView.setText(String.valueOf(score));
    }

}
