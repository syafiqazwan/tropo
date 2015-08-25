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
 * Created by Meister Fiq on 22/6/2015.
 */
public class MyListFragmentUnit extends ListFragment implements AdapterView.OnItemClickListener
{
    String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragmentunit, null, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.titles_unit);
        menuIcons = getResources().obtainTypedArray(R.array.icons_unit);

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
            case 0: //PERPUSTAKAAN
                Intent intent = new Intent(getActivity(), U_PERPUSTAKAAN.class);
                startActivity(intent);
                break;

            case 1: //PERHUBUNGAN & LATIHAN INDUSTRI
                Intent intent1 = new Intent(getActivity(), U_UPLI.class);
                startActivity(intent1);
                break;

            case 2: //PEPERIKSAAN
                Intent intent2 = new Intent(getActivity(), U_PEPERIKSAAN.class);
                startActivity(intent2);
                break;

            case 3: //SUKAN & KOKURIKULUM
                Intent intent3 = new Intent(getActivity(), U_SUKAN.class);
                startActivity(intent3);
                break;

            case 4: //ASRAMA
                Intent intent4 = new Intent(getActivity(), U_ASRAMA.class);
                startActivity(intent4);
                break;

            case 5: //TEKNOLOGI MAKLUMAT
                Intent intent5 = new Intent(getActivity(), U_UTM.class);
                startActivity(intent5);
                break;

            case 6: //PEMBANGUNAN INSTRUKSIONAL & MULTIMEDIA
                Intent intent6 = new Intent(getActivity(), U_CIDM.class);
                startActivity(intent6);
                break;

            case 7: //PEMBANGUNAN & SENGGARAAN
                Intent intent7 = new Intent(getActivity(), U_PS.class);
                startActivity(intent7);
                break;

            case 8: //PENTADBIRAN
                Intent intent8 = new Intent(getActivity(), U_ADMIN.class);
                startActivity(intent8);
                break;

            case 9: //KEWANGAN
                Intent intent9 = new Intent(getActivity(), U_WANG.class);
                startActivity(intent9);
                break;

            case 10: //JAMINAN KUALITI
                Intent intent10 = new Intent(getActivity(), U_JK.class);
                startActivity(intent10);
                break;

            case 11: //CISEC
                Intent intent11 = new Intent(getActivity(), U_CISEC.class);
                startActivity(intent11);
                break;

            case 12: //PENYELIDIKAN & INOVASI
                Intent intent12 = new Intent(getActivity(), U_PI.class);
                startActivity(intent12);
                break;

            case 13: //PSIKOLOGI & KERJAYA
                Intent intent13 = new Intent(getActivity(), U_PK.class);
                startActivity(intent13);
                break;

            case 14: //PERHUBUNGAN AWAM
                Intent intent14 = new Intent(getActivity(), U_PA.class);
                startActivity(intent14);
                break;

            case 15: //LATIHAN * PENDIDIKAN LANJUTAN
                Intent intent15 = new Intent(getActivity(), U_LPL.class);
                startActivity(intent15);
                break;

            case 16: //KEUSAHAWANAN
                Intent intent16 = new Intent(getActivity(), U_UK.class);
                startActivity(intent16);
                break;

            case 17: //CLINIC (MEDICAL ASSISTANT)
                Intent intent17 = new Intent(getActivity(), U_MA.class);
                startActivity(intent17);
                break;

            case 18: //CENTRE OF TECHNOLOGY
                Intent intent18 = new Intent(getActivity(), U_COT.class);
                startActivity(intent18);
                break;

        }

    }

}
