package com.example.tropo;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ViewSwitcher;

/**
 * Created by Syafiq Azlan on 14/7/2015.
 */
public class Map_JTMK_JMSK extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.map_building_layout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter_MAP_JTMK_JMSK adapter = new ImageAdapter_MAP_JTMK_JMSK(this);
        viewPager.setAdapter(adapter);
    }

}
