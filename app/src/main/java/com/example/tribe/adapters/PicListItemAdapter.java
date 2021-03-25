package com.example.tribe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tribe.R;
import com.example.tribe.entities.Pic;

import java.util.ArrayList;
import java.util.List;

public class PicListItemAdapter extends ArrayAdapter<Integer> {
    private List<Integer> picItemList;
    private int layout;
    private LayoutInflater inflater;

    public PicListItemAdapter(Context context, int resource, ArrayList<Integer> picItemList) {
        super(context, resource, picItemList);
        this.picItemList = picItemList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PicListItemAdapter.ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new PicListItemAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (PicListItemAdapter.ViewHolder) convertView.getTag();
        }

        Integer picItem = picItemList.get(position);
        viewHolder.picItemImage.setImageResource(picItem);

        return convertView;
    }

    private class ViewHolder {
        final ImageView picItemImage;

        ViewHolder(View view){
            picItemImage = (ImageView)view.findViewById(R.id.picListItemImage);
        }
    }
}
