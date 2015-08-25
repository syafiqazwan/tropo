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
public class lab_JTMK extends Activity
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
                "Makmal Rangkaian Komputer (RK)",
                "Makmal Pembangunan Aplikasi (PA)",
                "Makmal Sistem Komputer & Digital (SKD)",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(lab_JTMK.this, R.layout.custom_listview, values);

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
                        break;
                    case 1:
                        Intent in1 = new Intent(getApplicationContext(),Fetch_JTMK_gl1.class);
                        startActivity(in1);
                        break;
                    case 2:
                        Intent in2 = new Intent(getApplicationContext(),Fetch_JTMK_gl2.class);
                        startActivity(in2);
                        break;
                    case 3:
                        Intent in3 = new Intent(getApplicationContext(),Fetch_JTMK_gl3.class);
                        startActivity(in3);
                        break;
                    case 4:
                        Intent in4 = new Intent(getApplicationContext(),Fetch_JTMK_gl3.class);
                        startActivity(in4);
                        break;
                    case 5:
                        Intent in5 = new Intent(getApplicationContext(),Fetch_JTMK_hp1.class);
                        startActivity(in5);
                        break;
                    case 6:
                        Intent in6 = new Intent(getApplicationContext(),Fetch_JTMK_hp2.class);
                        startActivity(in6);
                        break;
                    case 7:
                        Intent in7 = new Intent(getApplicationContext(),Fetch_JTMK_rk.class);
                        startActivity(in7);
                        break;
                    case 8:
                        Intent in8 = new Intent(getApplicationContext(),Fetch_JTMK_pa.class);
                        startActivity(in8);
                        break;
                    case 9:
                        Intent in9 = new Intent(getApplicationContext(),Fetch_JTMK_skd.class);
                        startActivity(in9);
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
