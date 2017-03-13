package guilherme.goodhire;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);

        String scores = preferences.getString("SCORES", "NO SCORES");

        TextView textViewScores = (TextView) findViewById(R.id.textViewScores);

        textViewScores.setText(scores);

    }



}
