package com.example.tribe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tribe.entities.Music;
import com.example.tribe.entities.Video;
import com.example.tribe.invoke.IntentInvoker;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String, Music> musicMap = new HashMap<>();
    HashMap<String, Video> videoMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMusic();
        setVideos();
    }

    public void openQr(View view) {
        scan();
    }

    public void openPic(View view) {
        IntentInvoker invoker = new IntentInvoker(this, PicActivity.class);
        invoker.invoke();
    }

    public void openEco(View view) {
        IntentInvoker invoker = new IntentInvoker(this, EcoActivity.class);
        invoker.invoke();
    }

    private void scan() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(QRActivity.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scanning code");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() != null) {
                String res = result.getContents();
                String idPart = res.substring(25);
                if(idPart.substring(0,5).equals("music")) {
                    Music music = musicMap.get(idPart.substring(0,idPart.length()));
                    Intent intent = new Intent(getApplicationContext(), AudioActivity.class);
                    intent.putExtra("executor",music.getExecutor());
                    intent.putExtra("name",music.getName());
                    intent.putExtra("flagRes",music.getFlagRes());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                } if(idPart.substring(0,5).equals("video")) {
                    Video video = videoMap.get(idPart.substring(0,idPart.length()));
                    Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                    intent.putExtra("flagRes",video.getFlagRes());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, "No results", Toast.LENGTH_LONG);
            }
        } else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    private void setMusic() {
        String[] musicExecutors = getResources().getStringArray(R.array.music_executor);
        String[] musicNames = getResources().getStringArray(R.array.music_name);

        musicMap.put("music1", new Music(R.raw.music1, musicExecutors[0], musicNames[0]));
        musicMap.put("music2", new Music(R.raw.music2, musicExecutors[1], musicNames[1]));
        musicMap.put("music3", new Music(R.raw.music3, musicExecutors[2], musicNames[2]));
        musicMap.put("music4", new Music(R.raw.music4, musicExecutors[3], musicNames[3]));
        musicMap.put("music5", new Music(R.raw.music5, musicExecutors[4], musicNames[4]));
        musicMap.put("music6", new Music(R.raw.music6, musicExecutors[5], musicNames[5]));
        musicMap.put("music7", new Music(R.raw.music7, musicExecutors[6], musicNames[6]));
        musicMap.put("music8", new Music(R.raw.music8, musicExecutors[7], musicNames[7]));
        musicMap.put("music9", new Music(R.raw.music9, musicExecutors[8], musicNames[8]));
        musicMap.put("music10", new Music(R.raw.music10, musicExecutors[9], musicNames[9]));
        musicMap.put("music11", new Music(R.raw.music11, musicExecutors[10], musicNames[10]));
        musicMap.put("music12", new Music(R.raw.music12, musicExecutors[11], musicNames[11]));
        musicMap.put("music13", new Music(R.raw.music13, musicExecutors[12], musicNames[12]));
        musicMap.put("music14", new Music(R.raw.music14, musicExecutors[13], musicNames[13]));
        musicMap.put("music15", new Music(R.raw.music15, musicExecutors[14], musicNames[14]));
        musicMap.put("music16", new Music(R.raw.music16, musicExecutors[15], musicNames[15]));
        musicMap.put("music17", new Music(R.raw.music17, musicExecutors[16], musicNames[16]));
        musicMap.put("music18", new Music(R.raw.music18, musicExecutors[17], musicNames[17]));
        musicMap.put("music19", new Music(R.raw.music19, musicExecutors[18], musicNames[18]));
        musicMap.put("music20", new Music(R.raw.music20, musicExecutors[19], musicNames[19]));
    }

    private void setVideos() {
        videoMap.put("video1", new Video(R.raw.video1));
        videoMap.put("video2", new Video(R.raw.video1));
        videoMap.put("video3", new Video(R.raw.video1));
        videoMap.put("video4", new Video(R.raw.video1));
        videoMap.put("video5", new Video(R.raw.video1));
        videoMap.put("video6", new Video(R.raw.video1));
        videoMap.put("video7", new Video(R.raw.video1));
        videoMap.put("video8", new Video(R.raw.video1));
        videoMap.put("video9", new Video(R.raw.video1));
        videoMap.put("video10", new Video(R.raw.video1));
        videoMap.put("video11", new Video(R.raw.video1));
        videoMap.put("video12", new Video(R.raw.video1));
        videoMap.put("video13", new Video(R.raw.video1));
        videoMap.put("video14", new Video(R.raw.video1));
    }
}