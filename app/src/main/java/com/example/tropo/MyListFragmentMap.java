package com.example.tropo;

import android.app.ListFragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meister Fiq on 22/6/2015.
 */
public class MyListFragmentMap extends ListFragment implements AdapterView.OnItemClickListener
{
    String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment_map, null, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.map_title);
        menuIcons = getResources().obtainTypedArray(R.array.map_icon);

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
            case 0: //General map
                Intent intent = new Intent(getActivity(), Map_general.class);
                startActivity(intent);
                break;
            case 1: //Departments map
                Intent intent1 = new Intent(getActivity(), Map_departments.class);
                startActivity(intent1);
                break;
            case 2: //Units map
                Intent intent2 = new Intent(getActivity(), Map_units.class);
                startActivity(intent2);
                break;
            case 3: //Sports map
                Intent intent3 = new Intent(getActivity(), Map_sport.class);
                startActivity(intent3);
                break;
            case 4: //Services map
                Intent intent4 = new Intent(getActivity(), Map_service.class);
                startActivity(intent4);
                break;
        }
    }
}
