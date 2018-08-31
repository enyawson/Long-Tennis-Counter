package com.example.android.longtenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int FIFTEEN_POINTS = 15;
    final int THIRTY_POINTS = 30;
    final int FORTY_POINTS =40;
    final int ONE_POINT = 1;

    int teamAGameWon, teamBGameWon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //DISPLAY FOR TEAM A
    //This method is called to display Team A points in a game
    public void displayForTeamAPoints (int score){
        TextView teamAPoints = (TextView)findViewById(R.id.team_a_game_points_text_view);
        teamAPoints.setText(String.valueOf(score));
    }

    public void displayForTeamAGameScore(int score){
        TextView teamAGameScore = (TextView)findViewById(R.id.team_a_game_won_text_view);
        teamAGameScore.setText(String.valueOf(score));
    }
    //This method is called to display Team A game Score ( a team needs 6 games to win a set)
    /*This method is called in sets scores when there is a minimum value of 6 and a difference of
     2 game points between teams*/
    public void displayForTeamAWinGame(){
        int teamAGameWonAboveFive, teamBGameWonAboveFive;
        int testSet1TeamA, testSet2TeamA, testSet3TeamA;

        int score = 0;
        // This assigns the value of Game won to variables, which is used to check if rules of gaming are met.
        teamAGameWonAboveFive = teamAGameWon;
        teamBGameWonAboveFive = teamBGameWon;

        //This takes the value of Set A1 and converts to an integer
        TextView teamASetOne = (TextView)findViewById(R.id.team_a_set_1_score_text_view);
        String getSetA1StringValueToBeConvertedToInt = teamASetOne.getText().toString();
        int convertSetA1StringValueToInt = Integer.parseInt(getSetA1StringValueToBeConvertedToInt);
        testSet1TeamA = convertSetA1StringValueToInt;

        //This takes the value of Set A2 and converts to an integer
        TextView teamASetTwo = (TextView)findViewById(R.id.team_a_set_2_score_text_view);
        String getSetA2StringValueToBeConvertedToInt = teamASetTwo.getText().toString();
        int convertSetA2StringValueToInt = Integer.parseInt(getSetA2StringValueToBeConvertedToInt);
        testSet2TeamA =convertSetA2StringValueToInt;

        //This takes the value of Set A3 and converts to an integer
        TextView teamASetThree = (TextView)findViewById(R.id.team_a_set_3_score_text_view);
        String getSetA3StringValueToBeConvertedToInt = teamASetThree.getText().toString();
        int convertSetA3StringValueToInt = Integer.parseInt(getSetA3StringValueToBeConvertedToInt);
        testSet3TeamA =convertSetA2StringValueToInt;


        if (testSet1TeamA == 0 && teamAGameWonAboveFive > 5 && (teamAGameWonAboveFive - teamBGameWonAboveFive)>=2 ){
            displayForTeamASetOne(teamAGameWonAboveFive);
            displayForTeamBSetOne(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();

        } else if ((testSet1TeamA != 0 && testSet2TeamA == 0 )&& teamAGameWonAboveFive > 5 && (teamAGameWonAboveFive - teamBGameWonAboveFive)>=2){
            displayForTeamASetTwo(teamAGameWonAboveFive);
            displayForTeamBSetTwo(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();
        } else if (testSet2TeamA != 0 && teamAGameWonAboveFive > 5 && (teamAGameWonAboveFive - teamBGameWonAboveFive)>=2){
            displayForTeamASetThree(teamAGameWonAboveFive);
            displayForTeamBSetThree(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();
        }
        else
        {
            teamAGameWon += ONE_POINT ;
            displayForTeamAGameScore(teamAGameWon);
            resetGamePoints();
        }

    }
    //This method is called to display Team A set 1 scores
    public void displayForTeamASetOne(int score){
        TextView teamASetOne = (TextView)findViewById(R.id.team_a_set_1_score_text_view);
        teamASetOne.setText(String.valueOf(score));
    }
    //This method is called to display Team A set 2 scores
    public void displayForTeamASetTwo(int score){
        TextView teamASetTwo = (TextView)findViewById(R.id.team_a_set_2_score_text_view);
        teamASetTwo.setText(String.valueOf(score));
    }
    //This method is called to display Team A set 3 scores
    public void displayForTeamASetThree(int score){
        TextView teamASetThree = (TextView)findViewById(R.id.team_a_set_3_score_text_view);
        teamASetThree.setText(String.valueOf(score));
    }

    //CLICK EVENT FOR TEAM A
    //This method is called to add 15 points to team A game point
    public void addToTeamA15Points(View view){
       int teamAGamePoints = FIFTEEN_POINTS;
        displayForTeamAPoints(teamAGamePoints);
    }
    //This method is called to add 30 points to team A game point
    public void addToTeamA30Points(View view){
        int teamAGamePoints =THIRTY_POINTS;
        displayForTeamAPoints(teamAGamePoints);
    }
    //This method is called to add 40 points to team A game point
    public void addToTeamA40Points(View view){
       int teamAGamePoints =FORTY_POINTS;
        displayForTeamAPoints(teamAGamePoints);
    }
    //This method is called to end a game
    //This method when called inserts values obtained into the required sets type and initialises
    //the game score and game points to zero.
    public void addToTeamAGamePoints(View view){
        displayForTeamAWinGame();

    }


    //DISPLAY FOR TEAM B
    //This method is called to display Team B points in a game
    public void displayForTeamBPoints (int score){
        TextView teamBPoints = (TextView)findViewById(R.id.team_b_game_points_text_view);
        teamBPoints.setText(String.valueOf(score));
    }
    public void displayForTeamBGameScore(int score){
        TextView teamBGameScore = (TextView)findViewById(R.id.team_b_game_won_text_view);
        teamBGameScore.setText(String.valueOf(score));
    }
    //This method is called to display Team B game Score ( a team needs six games to win a set)
    /*This method is called in sets scores when there is a minimum value of 6 and a difference of
     2 game points between teams*/
    public void displayForTeamBWinGame(){
        int teamAGameWonAboveFive, teamBGameWonAboveFive;
        int testSet1TeamB, testSet2TeamB, testSet3TeamB;

        int score = 0;
        // This assigns the value of Game won to variables, which is used to check if rules of gaming are met.
        teamAGameWonAboveFive = teamAGameWon;
        teamBGameWonAboveFive = teamBGameWon;

        //This takes the value of Set B1 and converts to an integer
        TextView teamBSetOne = (TextView)findViewById(R.id.team_b_set_1_score_text_view);
        String getSetB1StringValueToBeConvertedToInt = teamBSetOne.getText().toString();
        int convertSetB1StringValueToInt = Integer.parseInt(getSetB1StringValueToBeConvertedToInt);
        testSet1TeamB = convertSetB1StringValueToInt;

        //This takes the value of Set B2 and converts to an integer
        TextView teamBSetTwo = (TextView)findViewById(R.id.team_b_set_2_score_text_view);
        String getSetB2StringValueToBeConvertedToInt = teamBSetTwo.getText().toString();
        int convertSetB2StringValueToInt = Integer.parseInt(getSetB2StringValueToBeConvertedToInt);
        testSet2TeamB =convertSetB2StringValueToInt;

        //This takes the value of Set B3 and converts to an integer
        TextView teamBSetThree = (TextView)findViewById(R.id.team_b_set_3_score_text_view);
        String getSetB3StringValueToBeConvertedToInt = teamBSetThree.getText().toString();
        int convertSetB3StringValueToInt = Integer.parseInt(getSetB3StringValueToBeConvertedToInt);
        testSet3TeamB =convertSetB2StringValueToInt;


        if (testSet1TeamB == 0 && teamBGameWonAboveFive > 5 && (teamBGameWonAboveFive - teamAGameWonAboveFive)>=2 ){
            displayForTeamASetOne(teamAGameWonAboveFive);
            displayForTeamBSetOne(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();

        } else if ((testSet1TeamB != 0 && testSet2TeamB == 0 ) && teamBGameWonAboveFive > 5 && (teamBGameWonAboveFive - teamAGameWonAboveFive)>=2){
            displayForTeamASetTwo(teamAGameWonAboveFive);
            displayForTeamBSetTwo(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();
        } else if (testSet2TeamB != 0 && teamBGameWonAboveFive > 5 && (teamBGameWonAboveFive - teamAGameWonAboveFive)>=2){
            displayForTeamASetThree(teamAGameWonAboveFive);
            displayForTeamBSetThree(teamBGameWonAboveFive);
            teamAGameWon = score ;
            teamBGameWon = score;
            resetGameWon();
            resetGamePoints();
        }
        else
        {
            teamBGameWon += ONE_POINT ;
            displayForTeamBGameScore(teamBGameWon);
            resetGamePoints();
        }

    }
    //This method is called to display Team B set 1 scores
    public void displayForTeamBSetOne(int score){
        TextView teamBSetOne = (TextView)findViewById(R.id.team_b_set_1_score_text_view);
        teamBSetOne.setText(String.valueOf(score));

    }
    //This method is called to display Team B set 2 scores
    public void displayForTeamBSetTwo(int score){
        TextView teamBSetTwo = (TextView)findViewById(R.id.team_b_set_2_score_text_view);
        teamBSetTwo.setText(String.valueOf(score));
    }
    //This method is called to display Team B set 3 scores
    public void displayForTeamBSetThree(int score){
        TextView teamBSetThree = (TextView)findViewById(R.id.team_b_set_3_score_text_view);
        teamBSetThree.setText(String.valueOf(score));
    }
    //CLICK EVENT FOR TEAM B
    //This method is called to add 15 points to team B game point
    public void addToTeamB15Points(View view){
        int teamBGamePoints = FIFTEEN_POINTS;
        displayForTeamBPoints(teamBGamePoints);
    }
    //This method is called to add 30 points to team B game point
    public void addToTeamB30Points(View view){
        int teamBGamePoints = THIRTY_POINTS;
        displayForTeamBPoints(teamBGamePoints);
    }
    //This method is called to add 40 points to team B game point
    public void addToTeamB40Points(View view){
        int teamBGamePoints = FORTY_POINTS;
        displayForTeamBPoints(teamBGamePoints);
    }
    //This method is called to end a game
    //This method when called inserts values obtained into the required sets type and initialises
    //the game score and game points to zero.
    public void addToTeamBGamePoints(View view){
        displayForTeamBWinGame();
    }
    //OTHER FUNCTIONS
    //This method when called sets the values of game point to zero
    public void resetGamePoints(){
        displayForTeamBPoints(0);
        displayForTeamAPoints(0);
    }
    //This method sets the game won to zero when the gaming requirement is met
    public void resetGameWon(){
        displayForTeamAGameScore(0);
        displayForTeamBGameScore(0);

    }

    // This resets all scores
    public void resetSetsScores(View view){
        resetGamePoints();
        resetGameWon();
        displayForTeamASetOne(0);
        displayForTeamBSetOne(0);
        displayForTeamASetTwo(0);
        displayForTeamBSetTwo(0);
        displayForTeamASetThree(0);
        displayForTeamBSetThree(0);
    }
}
