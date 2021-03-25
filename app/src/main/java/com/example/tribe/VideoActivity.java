package com.example.tribe;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tribe.controllers.MediaButtonController;
import com.example.tribe.invoke.IntentInvoker;

public class VideoActivity extends AppCompatActivity {
    VideoView videoPlayer;
    ImageButton playBtn, pauseBtn;
    MediaButtonController mediaButtonController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        playBtn = (ImageButton) findViewById(R.id.playBtn);
        pauseBtn = (ImageButton) findViewById(R.id.pauseBtn);
        videoPlayer = (VideoView) findViewById(R.id.videoPlayer);
        videoPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        mediaButtonController = new MediaButtonController(playBtn, pauseBtn);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null) {
            int flagRes = arguments.getInt("flagRes");

            Uri myVideoUri = Uri.parse( "android.resource://" + getPackageName() + "/" + flagRes);
            videoPlayer.setVideoURI(myVideoUri);
        }
    }

    public void stopPlay() {
        mediaButtonController.stop();
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

    public void play(View view) {
        if(videoPlayer.isPlaying())
            return;

        videoPlayer.start();
        mediaButtonController.play();
    }

    public void pause(View view) {
        if(!videoPlayer.isPlaying())
            return;

        videoPlayer.pause();
        mediaButtonController.pause();
    }

    public void goToMain(View view) {
        IntentInvoker invoker = new IntentInvoker(this, MainActivity.class);
        invoker.invokeAndClean();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videoPlayer.isPlaying()) {
            stopPlay();
        }
    }
}