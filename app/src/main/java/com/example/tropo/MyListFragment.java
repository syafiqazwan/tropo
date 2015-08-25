package com.example.tropo;

/**
 * Created by Meister Fiq on 31/5/2015.
 */

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

//Listview for Departments
public class MyListFragment extends ListFragment implements OnItemClickListener {

    String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.titles);
        menuIcons = getResources().obtainTypedArray(R.array.icons);

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
            case 0: //JTMK
                Intent intent = new Intent(getActivity(), Dpt_JTMK.class);
                startActivity(intent);
                break;

            case 1: //JPH
                Intent intent1 = new Intent(getActivity(), Dpt_JPH.class);
                startActivity(intent1);
                break;

            case 2: //JP
                Intent intent2 = new Intent(getActivity(), Dpt_JP.class);
                startActivity(intent2);
                break;

            case 3: //JKA
                Intent intent3 = new Intent(getActivity(), Dpt_JKA.class);
                startActivity(intent3);
                break;

            case 4: //JKE
                Intent intent4 = new Intent(getActivity(), Dpt_JKE.class);
                startActivity(intent4);
                break;

            case 5: //JPA
                Intent intent5 = new Intent(getActivity(), Dpt_JPA.class);
                startActivity(intent5);
                break;

            case 6: //JMSK
                Intent intent6 = new Intent(getActivity(), Dpt_JMSK.class);
                startActivity(intent6);
                break;

            case 7: //JHEP
                Intent intent7 = new Intent(getActivity(), Dpt_JHEP.class);
                startActivity(intent7);
                break;
        }

    }
    
}
