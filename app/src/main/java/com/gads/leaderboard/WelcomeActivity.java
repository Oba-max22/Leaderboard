package com.gads.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Handler handler = new Handler();

        handler.postDelayed(this::launchHome, 2000);
    }
    private void launchHome(){
        startActivity( new Intent(this, MainActivity.class));
    }
}