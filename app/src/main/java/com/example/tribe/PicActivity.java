package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tribe.adapters.PicAdapter;
import com.example.tribe.entities.Eco;
import com.example.tribe.entities.Pic;
import com.example.tribe.invoke.IntentInvoker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PicActivity extends AppCompatActivity {

    ArrayList<Pic> pics = new ArrayList();
    ListView picMainList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);

        setInitialData();
        picMainList = (ListView) findViewById(R.id.picMainList);

        PicAdapter picAdapter = new PicAdapter(this, R.layout.pic_list_item, pics);
        picMainList.setAdapter(picAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pic pic = (Pic) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), PicListItemActivity.class);
                intent.putExtra("name", pic.getName());
                intent.putExtra("flagPics", pic.getFlagPics());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        };
        picMainList.setOnItemClickListener(itemClickListener);
    }

    private void setInitialData() {
        String[] picTitles = getResources().getStringArray(R.array.pic_titles);
        String[] picNames = getResources().getStringArray(R.array.pic_name);
        String[] picDates = getResources().getStringArray(R.array.pic_date);
        TypedArray picArraysOfArtist = getResources().obtainTypedArray(R.array.pic_arrays_of_artists);
        TypedArray picMainArts = getResources().obtainTypedArray(R.array.pic_main_arts);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date();
        try{
            pics.add(new Pic(picTitles[0], picNames[0], picMainArts.getResourceId(0,0),
                picArraysOfArtist.getResourceId(0,0)));
            for(int i=1; i<picMainArts.length(); i++) {
                if(curDate.after(formatter.parse(picDates[i])) || curDate.equals(formatter.parse(picDates[i])))
                    pics.add(new Pic(picTitles[i], picNames[i], picMainArts.getResourceId(i,0),
                        picArraysOfArtist.getResourceId(i,0)));
            }
        } catch (ParseException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public void goToMain(View view) {
        IntentInvoker invoker = new IntentInvoker(this, MainActivity.class);
        invoker.invokeAndClean();
    }
}