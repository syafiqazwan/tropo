package com.example.tropo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ilfakluz on 12/7/2015.
 */
//cidm - unit pembangunan infrastruksional & multimedia - u_pembangunan
public class U_CIDM extends Activity
{
    Button button;

    public static final String TAG = "pembangunan infrastruktur";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_pembangunan);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button_back);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });


    }}
