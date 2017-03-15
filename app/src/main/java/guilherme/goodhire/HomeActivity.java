package guilherme.goodhire;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


    /*
    *Good Hire Game
    *Author: Guilherme Ferreira Mello
    *Releasing: 03/03/2017
    */


public class HomeActivity extends AppCompatActivity {

    //creating a MediaPlayer class variable
    MediaPlayer introHome;

    //creating a Buttons class variables
    Button btSinglePlayer, btMultiPlayer, btScore, btAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //start to play the intro song that is in res>raw files
        introHome=MediaPlayer.create(HomeActivity.this,R.raw.intro1);
        introHome.setLooping(true);
        introHome.start();




        /*
        create a sound in a button of singleplayer game mode and changing the activity
         */
        btSinglePlayer = (Button)findViewById(R.id.buttonSinglePlayer);
        final MediaPlayer myMediabtSinglePlayer = MediaPlayer.create(this, R.raw.button2);
        final Intent myIntentSinglePlayer = new Intent(this, SinglePlayer.class);
        btSinglePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntentSinglePlayer);
                myMediabtSinglePlayer.start();
            }
        });



        /*
        create a sound in a button of multiplayer game mode and changing the activity
         */
        btMultiPlayer = (Button)findViewById(R.id.buttonMultiplayer);
        final MediaPlayer myMediabtMultiPlayer = MediaPlayer.create(this, R.raw.button2);
        final Intent myIntentMultiPlayer = new Intent(this, MultiplayerActivity.class);
        btMultiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntentMultiPlayer);
                myMediabtMultiPlayer.start();
            }
        });




        /*
        create a sound in a button of Score game mode and changing the activity
         */
        btScore = (Button)findViewById(R.id.buttonScore);
        final MediaPlayer myMediabtScore = MediaPlayer.create(this, R.raw.button2);
        final Intent myIntentScore = new Intent(this, ScoresActivity.class);
        btScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntentScore);
                myMediabtScore.start();
            }
        });



        /*
        create a sound in a button of About game mode and changing the activity
         */
        btAbout = (Button)findViewById(R.id.buttonAbout);
        final MediaPlayer myMediabtAbout = MediaPlayer.create(this, R.raw.button2);
        final Intent myIntentAbout = new Intent(this, AboutActivity.class);
        btAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntentAbout);
                myMediabtAbout.start();
            }
        });


    }



    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onPause(){
        super.onPause();
        introHome.release();

    }



}
