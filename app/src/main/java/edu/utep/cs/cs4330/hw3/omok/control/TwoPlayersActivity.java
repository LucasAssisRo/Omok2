package edu.utep.cs.cs4330.hw3.omok.control;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import edu.utep.cs.cs4330.hw3.omok.R;

public class TwoPlayersActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            Fragment fragment = null;
            if (arg0 == 0) {
                fragment = new TwoPlayersActivityFragment();
            } else if (arg0 == 1) {
                fragment = new GameFragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
