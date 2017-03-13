package guilherme.goodhire;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {


    int myPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        //Showing the number of points won for each correct words (1 point for word guessed)
        int points = getIntent().getIntExtra("POINTS_IDENTIFIER", 0);

        TextView textViewPoints = (TextView) findViewById(R.id.textViewPointsGameOverNumber);
        textViewPoints.setText(String.valueOf(points));

        myPoints = points;

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

}
