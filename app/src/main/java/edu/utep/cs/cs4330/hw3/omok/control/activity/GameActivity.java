package edu.utep.cs.cs4330.hw3.omok.control.activity;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.fragment.GameFragment;
import edu.utep.cs.cs4330.hw3.omok.view.BoardView;

/**
 * Created by lucasassisrodrigues on 3/21/16.
 */
public abstract class GameActivity extends AppCompatActivity {
    protected ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        assignLayout(savedInstanceState);
    }

    protected abstract void assignLayout(Bundle savedInstanceState);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_game, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final GameFragment gameFragment;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gameFragment = (GameFragment) ((GameFragmentAdapter) viewPager.getAdapter()).getRegisteredFragment(1);
        } else {
            gameFragment = (GameFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_game);
        }
        switch (id) {
            case R.id.action_player_one_color:
                createDialog(R.array.player_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                gameFragment.getBoardView().setPlayerOneColorID(R.color.black);
                                break;
                            case 1:
                                gameFragment.getBoardView().setPlayerOneColorID(R.color.dark_blue);
                                break;
                            case 2:
                                gameFragment.getBoardView().setPlayerOneColorID(R.color.dark_green);
                                break;
                        }
                    }
                });
                break;
            case R.id.action_player_two_color:
                createDialog(R.array.player_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                gameFragment.getBoardView().setPlayerTwoColorID(R.color.white);
                                break;
                            case 1:
                                gameFragment.getBoardView().setPlayerTwoColorID(R.color.light_blue);
                                break;
                            case 2:
                                gameFragment.getBoardView().setPlayerTwoColorID(R.color.light_green);
                                break;
                        }
                    }
                });
                break;
            case R.id.action_game_color:
                createDialog(R.array.board_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                gameFragment.getBoardView().setBackgroundColorID(R.color.beige);
                                break;
                            case 1:
                                gameFragment.getBoardView().setBackgroundColorID(R.color.brown);
                                break;
                            case 2:
                                gameFragment.getBoardView().setBackgroundColorID(R.color.orange);
                                break;
                        }
                    }
                });
                break;
            case R.id.action_line_color:
                createDialog(R.array.line_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                gameFragment.getBoardView().setLineColorID(R.color.black);
                                break;
                            case 1:
                                gameFragment.getBoardView().setLineColorID(R.color.purple);
                                break;
                            case 2:
                                gameFragment.getBoardView().setLineColorID(R.color.pink);
                                break;
                        }
                    }
                });
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createDialog(int arrayID, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pick_color).setItems(arrayID, listener);
        alertDialog = builder.create();
        alertDialog.show();
    }

    abstract class GameFragmentAdapter extends FragmentPagerAdapter {
        SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

        public GameFragmentAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        public Fragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }
    }

}