package guilherme.goodhire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    //Intent for Single Player Activity and Button
    public void startSinglePlayerGame (View v){
        Intent myIntentSinglePlayer = new Intent(this, SinglePlayer.class);
        startActivity(myIntentSinglePlayer);
    }


    //Intent for Single Player Activity and Button
    public void aboutActivity (View v){
        Intent myIntentAbout = new Intent(this, AboutActivity.class);
        startActivity(myIntentAbout);
    }


    public void openScores (View view){
        Intent myIntentScores = new Intent(this, ScoresActivity.class);
        startActivity(myIntentScores);
    }


}
