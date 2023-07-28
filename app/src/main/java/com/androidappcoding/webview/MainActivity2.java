package com.androidappcoding.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    CardView pexels, youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pexels = findViewById(R.id.pexels);
        youtube = findViewById(R.id.youtube);

        pexels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                MainActivity.webview2 = "https://www.youtube.com/";

            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                MainActivity.webview2 = "https://www.youtube.com/";
            }
        });


    }



    private long lastpressedtime;
    private static final int period = 2000;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            switch (event.getAction()) {
                case KeyEvent.ACTION_DOWN:
                    if (event.getDownTime() - lastpressedtime < period) {
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Press again to exit.",
                                Toast.LENGTH_SHORT).show();
                        lastpressedtime = event.getEventTime();
                    }
                    return true;
            }
        }

        return false;
    }

}