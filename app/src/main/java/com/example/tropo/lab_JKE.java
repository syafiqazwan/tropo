package com.example.tropo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Syafiq Azlan on 4/7/2015.
 */
public class lab_JKE extends Activity
{
    ListView listView ;

    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_jtmk);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] {
                "Office",
                "Makmal Teknologi Maklumat 1 (TM1)",
                "Makmal Komputer Am 1 (GL1)",
                "Makmal Komputer Am 1 (GL2)",
                "Makmal Komputer Am 1 (GL3)",
                "Makmal Hypermedia 1",
                "Makmal Hypermedia 2",
                "Makmal Hypermedia 3",
                "Makmal Rangkaian Komputer (RK)",
                "Makmal Pembangunan Aplikasi (PA)",
                "Makmal Sistem Komputer & Digital (SKD)",
                "Makmal CAD 1",
                "Makmal CAD 2",
                "Makmal CAD 3"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(lab_JKE.this, R.layout.custom_listview, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        Intent in = new Intent(getApplicationContext(),Fetch_JTMK_Office.class);
                        startActivity(in);
                }
            }

        });

        addListenerOnButton();
    }


    public void addListenerOnButton() {
        Button close_button = (Button) findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
