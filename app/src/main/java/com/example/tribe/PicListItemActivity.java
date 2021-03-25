package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tribe.adapters.PicAdapter;
import com.example.tribe.adapters.PicListItemAdapter;
import com.example.tribe.entities.Pic;
import com.example.tribe.invoke.IntentInvoker;

import java.util.ArrayList;

public class PicListItemActivity extends AppCompatActivity {
    ArrayList<Integer> picItems = new ArrayList();
    TextView nameText;
    ListView picItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_list_item);

        nameText = (TextView) findViewById(R.id.nameText);
        picItemList = (ListView) findViewById(R.id.picItemList);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null) {
            String name = arguments.getString("name");
            int flagPics = arguments.getInt("flagPics");

            nameText.setText(name);
            TypedArray picArts = getResources().obtainTypedArray(flagPics);
            for(int i=0; i<picArts.length(); i++) {
                picItems.add(picArts.getResourceId(i,0));
            }

            PicListItemAdapter picItemAdapter = new PicListItemAdapter(this, R.layout.pic_list_item_image, picItems);
            picItemList.setAdapter(picItemAdapter);
        }
    }

    public void getBack(View view) {
        IntentInvoker invoker = new IntentInvoker(this, PicActivity.class);
        invoker.invokeAndClean();
    }
}