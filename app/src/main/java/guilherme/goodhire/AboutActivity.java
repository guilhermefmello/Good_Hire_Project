package guilherme.goodhire;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


    /*
    *Good Hire Game
    *Author: Guilherme Ferreira Mello
    *Releasing: 03/03/2017
    */

public class AboutActivity extends AppCompatActivity {


    //creating a MediaPlayer class variable introAbout
    MediaPlayer introAbout;


    WebView myHtmlView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        //start to play the intro song in a About screen (that is in res>raw files)
        introAbout= MediaPlayer.create(AboutActivity.this,R.raw.intro5);
        introAbout.setLooping(true);
        introAbout.start();


        //create a html view
        myHtmlView = (WebView) findViewById(R.id.aboutWebView);
        myHtmlView.loadUrl("file:///android_asset/about.html");
        myHtmlView.getSettings().setJavaScriptEnabled(true);




    }




    //creating a method to pause (or stops) the intro song when a button is pressed or an activity is changed
    @Override
    protected void onPause(){
        super.onPause();
        introAbout.release();

    }



}
