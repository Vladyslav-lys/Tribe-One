package com.example.tribe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tribe.R;
import com.example.tribe.entities.Eco;
import com.example.tribe.entities.Pic;

import java.util.ArrayList;
import java.util.List;

public class PicAdapter extends ArrayAdapter<Pic> {

    private List<Pic> picList;
    private int layout;
    private LayoutInflater inflater;

    public PicAdapter(Context context, int resource, ArrayList<Pic> picList) {
        super(context, resource, picList);
        this.picList = picList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PicAdapter.ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new PicAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (PicAdapter.ViewHolder) convertView.getTag();
        }
        Pic pic = picList.get(position);

        viewHolder.picImage.setImageResource(pic.getFlagRes());
        viewHolder.titleText.setText(pic.getTitle());

        return convertView;
    }

    private class ViewHolder {
        final ImageView picImage;
        final TextView titleText;

        ViewHolder(View view){
            picImage = (ImageView)view.findViewById(R.id.picImage);
            titleText = (TextView) view.findViewById(R.id.titleText);
        }
    }
}
