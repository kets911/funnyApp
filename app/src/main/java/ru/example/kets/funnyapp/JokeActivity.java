package ru.example.kets.funnyapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by kets on 12.09.2017.
 */

public class JokeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBegin, btnCount;
    private TextView teXt;
    private LinearLayout layout;
    private Vibrator vibrator;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        btnBegin = (Button) findViewById(R.id.btnBegin);
        btnCount = (Button) findViewById(R.id.btnCount);
        teXt = (TextView) findViewById(R.id.text);
        btnBegin.setOnClickListener(this);
        btnCount.setOnClickListener(this);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        layout = (LinearLayout) findViewById(R.id.layout);
        mediaPlayer = MediaPlayer.create(this, R.raw.screencracksound);

        btnBegin.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBegin:
                btnCount.setText(String.valueOf(100));
                btnCount.setVisibility(View.VISIBLE);
                teXt.setVisibility(View.VISIBLE);
                btnBegin.setVisibility(View.GONE);
                layout.setBackgroundResource(0);
                break;
            case R.id.btnCount:
                int counter = Integer.parseInt(btnCount.getText().toString());
                btnCount.setText(String.valueOf(--counter));
                if((new Random().nextInt(10)+1 == 10) || (counter < 50)){
                    doCrack();
                }
                break;
        }

    }
    private void doCrack(){
        doVibration();
        setBackground();
        playMusic();
        teXt.setVisibility(View.INVISIBLE);
        btnBegin.setVisibility(View.VISIBLE);
    }

    private void playMusic() {
        mediaPlayer.start();
    }

    private void setBackground() {
        layout.setBackgroundResource(R.drawable.crack);
        btnCount.setVisibility(View.GONE);
    }

    private void doVibration() {
        long[] pattern = {0, 500, 0};
        vibrator.vibrate(pattern, -1);
    }
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
