package com.gads.leaderboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    private String[] title = {"Learning Leaders", "Skill IQ Leaders"};
    public TabAdapter(Context c,FragmentManager fm, int totalTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        context = c;
        this.totalTabs = totalTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LearningFragment();
        }
        return new SkillFragment();
    }

    @Override
    public int getCount() {
            return title.length;
        }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
