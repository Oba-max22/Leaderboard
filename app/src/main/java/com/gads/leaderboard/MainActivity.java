package com.gads.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        final TabAdapter adapter = new TabAdapter(this,getSupportFragmentManager(),
                tabs.getTabCount());
        viewPager.setAdapter(adapter);

    }

    public void Submission(View view) {
        Intent intent = new Intent(this, SubmitActivity.class);
        startActivity(intent);
    }
}