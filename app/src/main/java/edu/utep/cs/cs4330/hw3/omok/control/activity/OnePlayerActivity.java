package edu.utep.cs.cs4330.hw3.omok.control.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.GameFragment;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.OnePlayerActivityFragment;
import edu.utep.cs.cs4330.hw3.omok.model.Board;
import edu.utep.cs.cs4330.hw3.omok.model.Computer;
import edu.utep.cs.cs4330.hw3.omok.model.Human;
import edu.utep.cs.cs4330.hw3.omok.model.OmokGame;
import edu.utep.cs.cs4330.hw3.omok.model.Strategy;
import edu.utep.cs.cs4330.hw3.omok.model.StrategyRandom;
import edu.utep.cs.cs4330.hw3.omok.model.StrategySmart;

public class OnePlayerActivity extends GameActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        omokGame = new OmokGame(true);
    }

    @Override
    protected void assignLayout(Bundle savedInstanceState) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new OnePlayerFragmentAdapter(getSupportFragmentManager()));
        } else {
            setContentView(R.layout.activity_one_player);
        }
    }

    @Override
    protected void startGame() {
        if(omokGame.isGameRunning()){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    omokGame.setGameRunning(false);
                    Toast.makeText(builder.getContext(), R.string.game_started, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    omokGame.setGameRunning(true);
                    Toast.makeText(builder.getContext(), R.string.new_game_canceled, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setMessage(R.string.new_game_prompt);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        if (!omokGame.isGameRunning()) {
            OnePlayerActivityFragment settingsFragment;
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                settingsFragment = (OnePlayerActivityFragment)
                        ((GameFragmentAdapter) viewPager.getAdapter()).getRegisteredFragment(0);
            } else {
                settingsFragment = (OnePlayerActivityFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment_one_player);
            }
            ((Human) omokGame.getPlayers()[0]).setName(settingsFragment.getEditTextPlayerOne().toString());
            Strategy strategy =
                    settingsFragment.getRadioButtonRandom().isChecked() ? new StrategyRandom() : new StrategySmart();
            ((Computer) omokGame.getPlayers()[1]).setStrategyMode(strategy);
            omokGame.setBoard(new Board());
        }
    }

    class OnePlayerFragmentAdapter extends GameFragmentAdapter {
        public OnePlayerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {
            // TODO Auto-generated method stub
            Fragment fragment = null;
            if (position == 0) {
                fragment = new OnePlayerActivityFragment();
            } else if (position == 1) {
                fragment = new GameFragment();
            }
            return fragment;
        }

    }
}
