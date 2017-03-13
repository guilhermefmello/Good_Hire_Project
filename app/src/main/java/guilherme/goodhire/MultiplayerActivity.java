package guilherme.goodhire;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MultiplayerActivity extends AppCompatActivity {

    //creating a MediaPlayer class variable
    MediaPlayer introMultiPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        //start to play the intro song in a multiplayer screen (that is in res>raw files)
        introMultiPlayer= MediaPlayer.create(MultiplayerActivity.this,R.raw.intro2);
        introMultiPlayer.setLooping(true);
        introMultiPlayer.start();

    }

    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onStop(){
        super.onStop();
        introMultiPlayer.release();


    }




    //sending the values inserted in the field used to create a new word (first multiplayer screen) to the multiplayer game screen.
    public void startMultiGame(View view){

        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String wordToGuess = editText.getText().toString();

        String upperCaseValue = wordToGuess.toUpperCase();

        editText.setText("");


        Intent myIntentMultiPlayer = new Intent(this, GameMultiActivity.class);
        myIntentMultiPlayer.putExtra("WORD_IDENTIFIER", upperCaseValue);
        //startActivity(myIntentMultiPlayer);



        if (upperCaseValue.length() > 0){
            startActivity(myIntentMultiPlayer);
        }else{
            Toast.makeText(this,"Please Insert a Word",Toast.LENGTH_SHORT).show();
        }




    }




}
