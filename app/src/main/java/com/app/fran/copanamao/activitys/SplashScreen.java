package com.app.fran.copanamao.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.fran.copanamao.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                telaMain();
            }
        }, 3000);

    }

    private void telaMain() {
        Intent intent = new Intent(SplashScreen.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }


}
