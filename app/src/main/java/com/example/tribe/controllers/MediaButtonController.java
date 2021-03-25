package com.example.tribe.controllers;

import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;

public class MediaButtonController {
    ImageButton playBtn, pauseBtn;

    public MediaButtonController(ImageButton playBtn, ImageButton pauseBtn) {
        this.playBtn = playBtn;
        this.pauseBtn = pauseBtn;

        setVisibilityPlayPause(View.VISIBLE, View.GONE);
    }

    public void stop() {
        pause();
    }

    public void play() {
        setVisibilityPlayPause(View.GONE, View.VISIBLE);
    }

    public void pause() {
        setVisibilityPlayPause(View.VISIBLE, View.GONE);
    }

    private void setVisibilityPlayPause(int playVisibility, int pauseVisibility) {
        playBtn.setVisibility(playVisibility);
        pauseBtn.setVisibility(pauseVisibility);
    }
}
