package edu.utep.cs.cs4330.hw3.omok.control.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.GameFragment;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.TwoPlayersActivityFragment;

public class TwoPlayersActivity extends GameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void assignLayout(Bundle savedInstanceState) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new TwoPlayersFragmentAdapter(getSupportFragmentManager()));
        }else{
            setContentView(R.layout.activity_two_players);
        }
    }

    class TwoPlayersFragmentAdapter extends GameFragmentAdapter {

        public TwoPlayersFragmentAdapter(FragmentManager fm) {
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

    }
}
