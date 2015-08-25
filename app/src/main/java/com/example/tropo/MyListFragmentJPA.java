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
public class MyListFragmentJPA extends ListFragment implements AdapterView.OnItemClickListener
{
    String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment_jka, null, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.lect_jtmk);
        menuIcons = getResources().obtainTypedArray(R.array.icons_jtmk);

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
            case 0: //Lecturer
                Intent intent = new Intent(getActivity(), Fetch_JPA.class);
                startActivity(intent);
                break;
            case 1: //lab
                Intent intent2 = new Intent(getActivity(), lab_JPA.class);
                startActivity(intent2);
                break;
            case 2: //gallery
                /*
                Intent intent3 = new Intent(getActivity(), lab_JTMK.class);
                startActivity(intent3); */
            case 3: //course
                /*
                Intent intent4 = new Intent(getActivity(), Course_JPA.class);
                startActivity(intent4);
                break; */
            case 4: //course
                Intent intent5 = new Intent(getActivity(), Contact_JPA.class);
                startActivity(intent5);
                break;
        }
    }
}
