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

import java.util.ArrayList;
import java.util.List;

public class EcoAdapter extends ArrayAdapter<Eco> {

    private List<Eco> ecoList;
    private int layout;
    private LayoutInflater inflater;

    public EcoAdapter(Context context, int resource, ArrayList<Eco> ecoList) {
        super(context, resource, ecoList);
        this.ecoList = ecoList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Eco eco = ecoList.get(position);

        viewHolder.ecoImage.setImageResource(eco.getFlagRes());
        viewHolder.nameText.setText(eco.getName());
        viewHolder.describeText.setText(eco.getDescribe());

        return convertView;
    }

    private class ViewHolder {
        final ImageView ecoImage;
        final TextView describeText, nameText;

        ViewHolder(View view){
            ecoImage = (ImageView)view.findViewById(R.id.ecoImage);
            nameText = (TextView) view.findViewById(R.id.nameText);
            describeText = (TextView) view.findViewById(R.id.describeText);
        }
    }
}
