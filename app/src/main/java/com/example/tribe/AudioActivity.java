package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tribe.controllers.MediaButtonController;
import com.example.tribe.invoke.IntentInvoker;

public class AudioActivity extends AppCompatActivity {
    ImageButton playBtn, pauseBtn;
    MediaPlayer mPlayer;
    TextView executorText, nameText;
    MediaButtonController mediaButtonController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        executorText = (TextView) findViewById(R.id.executorText);
        nameText = (TextView) findViewById(R.id.nameText);
        playBtn = (ImageButton) findViewById(R.id.playBtn);
        pauseBtn = (ImageButton) findViewById(R.id.pauseBtn);

        mediaButtonController = new MediaButtonController(playBtn, pauseBtn);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null) {
            String executor = arguments.getString("executor");
            String name = arguments.getString("name");
            int flagRes = arguments.getInt("flagRes");

            mPlayer = MediaPlayer.create(this, flagRes);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });

            executorText.setText(executor);
            nameText.setText(name);
        }
    }

    private void stopPlay(){
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);

            mediaButtonController.stop();
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view) {
        if(mPlayer.isPlaying())
            return;

        mPlayer.start();
        mediaButtonController.play();
    }

    public void pause(View view) {
        if(!mPlayer.isPlaying())
            return;

        mPlayer.pause();
        mediaButtonController.pause();
    }

    public void goToMain(View view) {
        IntentInvoker invoker = new IntentInvoker(this, MainActivity.class);
        invoker.invokeAndClean();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}