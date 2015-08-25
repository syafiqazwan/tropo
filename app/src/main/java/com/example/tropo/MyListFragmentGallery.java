package com.example.tropo;

import android.app.ListFragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilfakluz on 11/7/2015.
 */
public class MyListFragmentGallery extends ListFragment implements AdapterView.OnItemClickListener
{
    String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment_gallery, null, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.title_gallery);
        menuIcons = getResources().obtainTypedArray(R.array.icons_gallery);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < menutitles.length; i++) {
            RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
                    i, -1));

            rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 0: //Panorama
                Intent intent = new Intent(getActivity(), Gallery_Panorama.class);
                startActivity(intent);
                break;
            case 1: //Indoor
                Intent intent2 = new Intent(getActivity(), Gallery_Indoor.class);
                startActivity(intent2);
                break;
            case 2: //Student activities
                Intent intent3 = new Intent(getActivity(), Gallery_Activities.class);
                startActivity(intent3);
                break;
        }
    }
}
