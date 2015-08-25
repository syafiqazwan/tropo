package com.example.tropo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Syafiq Azlan on 6/7/2015.
 */
public class Course_JP extends Activity
{
    ListView listView;
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_jtmk);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] {
                "Diploma Sains Kesetiausahaan - DSK",
                "Diploma Islamic Banking - DIB"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Course_JP.this, R.layout.custom_listview_course, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
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
