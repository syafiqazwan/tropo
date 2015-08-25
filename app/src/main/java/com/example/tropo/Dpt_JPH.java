package com.example.tropo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ilfakluz on 12/7/2015.
 */
public class Dpt_JPH extends Activity
{
    Button button;

    public static final String TAG = "jph";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dpt_jph);
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
