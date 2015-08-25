package com.example.tropo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class Gallery_JTMK extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gallery_jtmk);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter_JTMK adapter = new ImageAdapter_JTMK(this);
        viewPager.setAdapter(adapter);
    }


}
