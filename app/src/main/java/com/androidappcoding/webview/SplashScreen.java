package com.androidappcoding.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageview;
    TextView splash_name;

    Animation Splash, Splashsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        imageview = findViewById(R.id.imageview);
        splash_name = findViewById(R.id.splash_name);

        Splash = AnimationUtils.loadAnimation(this, R.anim.silde);
        Splashsite = AnimationUtils.loadAnimation(this, R.anim.sildelift);

        imageview.setAnimation(Splash);
        splash_name.setAnimation(Splashsite);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this, MainActivity2.class));
                finish();

            }
        },2000);



    }
}