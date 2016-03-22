package edu.utep.cs.cs4330.hw3.omok.control.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.GameFragment;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.OnePlayerActivityFragment;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.TwoPlayersActivityFragment;
import edu.utep.cs.cs4330.hw3.omok.model.Board;
import edu.utep.cs.cs4330.hw3.omok.model.Computer;
import edu.utep.cs.cs4330.hw3.omok.model.Human;
import edu.utep.cs.cs4330.hw3.omok.model.OmokGame;
import edu.utep.cs.cs4330.hw3.omok.model.Strategy;
import edu.utep.cs.cs4330.hw3.omok.model.StrategyRandom;
import edu.utep.cs.cs4330.hw3.omok.model.StrategySmart;

public class TwoPlayersActivity extends GameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        omokGame = new OmokGame(false);
    }

    @Override
    protected void assignLayout(Bundle savedInstanceState) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new TwoPlayersFragmentAdapter(getSupportFragmentManager()));
        } else {
            setContentView(R.layout.activity_two_players);
        }
    }

    @Override
    public void startGame() {
        if (omokGame.isGameRunning()) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    omokGame.setGameRunning(false);
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
            TwoPlayersActivityFragment settingsFragment;
            GameFragment gameFragment;
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                settingsFragment = (TwoPlayersActivityFragment)
                        ((GameFragmentAdapter) viewPager.getAdapter()).getRegisteredFragment(0);
                gameFragment = (GameFragment)
                        ((GameFragmentAdapter) viewPager.getAdapter()).getRegisteredFragment(1);
            } else {
                settingsFragment = (TwoPlayersActivityFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment_two_players);
                gameFragment = (GameFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment_game);
            }
            ((Human) omokGame.getPlayers()[0]).setName(settingsFragment.getEditTextPlayerOne().toString());
            ((Human) omokGame.getPlayers()[1]).setName(settingsFragment.getEditTextPlayerTwo().toString());
            omokGame.setBoard(new Board());
            omokGame.setGameRunning(true);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                viewPager.setCurrentItem(1);
            gameFragment.getBoardView().invalidate();
            Toast.makeText(this, R.string.game_started, Toast.LENGTH_SHORT).show();
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
