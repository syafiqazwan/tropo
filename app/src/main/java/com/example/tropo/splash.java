package com.example.tropo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class splash extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        //Hide action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Call splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView img_animation = (ImageView) findViewById(R.id.splash);
        TranslateAnimation animation = new TranslateAnimation(-500, 0,0, 0);
        animation.setDuration(2000);
        animation.setRepeatCount(0);
        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        img_animation.startAnimation(animation);

        ImageView img_animation2 = (ImageView) findViewById(R.id.splash2);
        TranslateAnimation animation2 = new TranslateAnimation(500, 0,0, 0);
        animation2.setDuration(2000);
        animation2.setRepeatCount(0);
        animation2.setRepeatMode(2);
        animation2.setFillAfter(true);
        img_animation2.startAnimation(animation2);

        //Set the delay in second
        int secondsDelayed = 3;

        //Navigate what to do in the delayed time
        new Handler().postDelayed(new Runnable()
        {
            //Navigate to MainActivity when the time is up
            public void run()
            {
                startActivity(new Intent(splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
