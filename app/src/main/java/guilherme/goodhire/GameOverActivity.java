package guilherme.goodhire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


    /*
    *Good Hire Game
    *Author: Guilherme Ferreira Mello
    *Releasing: 03/03/2017
    */

public class GameOverActivity extends AppCompatActivity {


    int myPoints;

    //creating a MediaPlayer class variable
    MediaPlayer introGameOver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        //start to play the game over song that is in res>raw files
        introGameOver= MediaPlayer.create(GameOverActivity.this,R.raw.game_over);
        introGameOver.start();



        //Showing the number of points won for each correct words (1 point for word guessed)
        int points = getIntent().getIntExtra("POINTS_IDENTIFIER", 0);

        TextView textViewPoints = (TextView) findViewById(R.id.textViewPointsGameOverNumber);
        textViewPoints.setText(String.valueOf(points));

        myPoints = points;

    }



    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onStop(){
        super.onStop();
        introGameOver.release();


    }



    /*
    Taking the name and score of the players
    Storing players' names and scores
     */
    public void saveScore (View view){
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editTextFieldName);
        String name = editText.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString("SCORES", "");

        editor.putString("SCORES",name + " " + myPoints + " POINTS \n" + previousScores);
        editor.commit();

        /*
        returning to the main screen after finish the game
        (coming from Scores Activity, first will go to Single Player Activity )
         */
        finish();


    }


    //Intent for Play Again Button bringing to the Single Player Screen
    public void startPlayAgain (View v){
        Intent myIntentPlayAgain = new Intent(this, SinglePlayer.class);
        startActivity(myIntentPlayAgain);
        finish();
    }




}
