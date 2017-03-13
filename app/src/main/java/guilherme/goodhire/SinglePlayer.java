package guilherme.goodhire;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SinglePlayer extends AppCompatActivity {

    String myWord;
    int mFailCounter = 0;
    int mSuccessCounter = 0;
    int mGuessedLetters = 0;
    int mPoints = 0;

    MediaPlayer introSingle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);


        //start to play the intro song in a singleplayer screen (that is in res>raw files)
        introSingle= MediaPlayer.create(SinglePlayer.this,R.raw.intro4);
        introSingle.setLooping(true);
        introSingle.start();


        setRandomWord();



    }



    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onPause(){
        super.onPause();
        introSingle.release();

    }




    /*
    button Check Letter
    retrieving the letter inserted on the editTextFieldLetter
     */
    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextFieldLetter);
        String letter = myEditText.getText().toString();

        myEditText.setText("");

        Log.d("MYLOG","The Letter Inserted is: " + letter);

        if (letter.length() > 0){
            checkLetter(letter.toUpperCase());
        }else {
            Toast.makeText(this,"Please Insert Letter",Toast.LENGTH_SHORT).show();
        }

    }


    /*
    In the word's fields:
    method to check if the letters inserted match the word
     */
    public void checkLetter(String introducedLetter){

        char charIntroduced = introducedLetter.charAt(0);

        boolean letterGuessed = false;

        for (int i=0; i<myWord.length(); i++){

            char charFromTheWord = myWord.charAt(i);

            Log.d("MYLOG", "Letter Being Checked is: " + charFromTheWord);

            if (charFromTheWord == charIntroduced){

                Log.d("MYLOG", "There was one match");

                letterGuessed = true;

                showLetterAtIndex(i,charIntroduced);

                mGuessedLetters++;

            }


        }


        if (letterGuessed == true){
            letterSuccess();
        }


        if (letterGuessed == false){
            letterFailed(Character.toString(charIntroduced));
        }

        if (mGuessedLetters == myWord.length()){

            Toast.makeText(this,"YOU WON 1 POINT!!!",Toast.LENGTH_SHORT).show();

            mPoints++;
            cleanScreen();

            setRandomWord();

        }

    }


    //Array Random Method to choose randomly the words provided inside the method
    public void setRandomWord(){

        String words = "ABILITY BALANCE DECIDED DYNAMIC HELPFUL IMPROVE SKILLED WILLING ACHIEVE EXCITED SUCCESS";
        String[] arrayWords = words.split(" ");

        Log.d("MYLOG", "THE ARRAY LENGTH IS "+arrayWords.length);

        int randomNumber = (int) (Math.random() * arrayWords.length);
        myWord = arrayWords[randomNumber];

    }



    /*
    clean both word's fields, when inserting a latter and when the word is guessed
     */
    public void cleanScreen(){
        TextView textViewFailed = (TextView) findViewById(R.id.textViewMissedLetters);
        textViewFailed.setText("");

        mGuessedLetters = 0;
        mFailCounter = 0;
        mSuccessCounter = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for (int i=0; i<layoutLetters.getChildCount(); i++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

        ImageView imageViewBad = (ImageView) findViewById(R.id.imageViewGameOver);
        imageViewBad.setImageResource(R.drawable.bad_hire_steps1);

        ImageView imageViewGood = (ImageView) findViewById(R.id.imageViewSuccess);
        imageViewGood.setImageResource(R.drawable.good_hire_steps1);

    }


    /*
    Show images for each letter inserted with success
     */
    public void letterSuccess(){
        mSuccessCounter = mSuccessCounter +1;

        ImageView imageView = (ImageView) findViewById(R.id.imageViewSuccess);

        if (mSuccessCounter == 1){
            imageView.setImageResource(R.drawable.good_hire_steps2);
        }else if (mSuccessCounter == 2){
            imageView.setImageResource(R.drawable.good_hire_steps3);
        }else if (mSuccessCounter == 3){
            imageView.setImageResource(R.drawable.good_hire_steps4);
        }else if (mSuccessCounter == 4){
            imageView.setImageResource(R.drawable.good_hire_steps5);
        }else if (mSuccessCounter == 5){
            imageView.setImageResource(R.drawable.good_hire_steps6);
        }else if (mSuccessCounter == 6){
            imageView.setImageResource(R.drawable.good_hire_steps7);
        }else if (mSuccessCounter == 7){
            imageView.setImageResource(R.drawable.good_hire_steps8);

            /*

            Intent successIntent = new Intent(this,SuccessActivity.class);
            successIntent.putExtra("POINTS_IDENTIFIER", mPoints);
            startActivity(successIntent);

            */

        }
    }




    /*
    method that shows the failure when the user insert a letter
     */

    public void letterFailed(String letterFailed){

        TextView textViewFailed = (TextView) findViewById(R.id.textViewMissedLetters);
        String previousFail = textViewFailed.getText().toString();
        textViewFailed.setText(previousFail + letterFailed);

        mFailCounter = mFailCounter +1;

        ImageView imageView = (ImageView) findViewById(R.id.imageViewGameOver);

        if (mFailCounter == 1){
            imageView.setImageResource(R.drawable.bad_hire_steps2);
        }else if (mFailCounter == 2){
            imageView.setImageResource(R.drawable.bad_hire_steps3);
        }else if (mFailCounter == 3){
            imageView.setImageResource(R.drawable.bad_hire_steps4);
        }else if (mFailCounter == 4){
            imageView.setImageResource(R.drawable.bad_hire_steps5);
        }else if (mFailCounter == 5){
            imageView.setImageResource(R.drawable.bad_hire_steps6);
        }else if (mFailCounter == 6){
            imageView.setImageResource(R.drawable.bad_hire_steps7);
        }else if (mFailCounter == 7){
            imageView.setImageResource(R.drawable.bad_hire_steps8);

            Intent gameOverIntent = new Intent(this,GameOverActivity.class);
            gameOverIntent.putExtra("POINTS_IDENTIFIER", mPoints);
            startActivity(gameOverIntent);

            /*
            returning to the main screen after finish the game
            (coming from Game Over Activity)
             */
            finish();

        }
    }




    /*
    Displaying a letter guessed by the user
     */
    public void showLetterAtIndex(int position, char letterGuessed){

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));
    }






}
