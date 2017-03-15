package guilherme.goodhire;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


    /*
    *Good Hire Game
    *Author: Guilherme Ferreira Mello
    *Releasing: 03/03/2017
    */

public class ScoresActivity extends AppCompatActivity {


    //creating a MediaPlayer class variable introScores
    MediaPlayer introScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);


        //start to play the intro song in a Score screen (that is in res>raw files)
        introScores= MediaPlayer.create(ScoresActivity.this,R.raw.intro3);
        introScores.setLooping(true);
        introScores.start();



        //saving the scores within the phone (using sharedpreferences)
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);

        String scores = preferences.getString("SCORES", "NO SCORES");

        TextView textViewScores = (TextView) findViewById(R.id.textViewScores);

        textViewScores.setText(scores);

    }


    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onPause(){
        super.onPause();
        introScores.release();

    }




}
