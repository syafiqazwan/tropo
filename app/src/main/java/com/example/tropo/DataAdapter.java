package com.example.tropo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Syafiq Azlan on 3/7/2015.
 */
//ni utk fetch
public class DataAdapter extends ArrayAdapter<Data> {
    private ArrayList<Data> items;
    private Context mContext;
    public DataAdapter(Context context, int textViewResourceID, ArrayList<Data> items){
        super(context,textViewResourceID,items);
        mContext = context;
        this.items = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        Data name = items.get(position);
        if(v==null){
            LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.data_list_items,null);

        }
        TextView title = (TextView)v.findViewById(R.id.textView3);
        if (title != null) {
            title.setText(name.getName());
        }
        return v;
    }
}