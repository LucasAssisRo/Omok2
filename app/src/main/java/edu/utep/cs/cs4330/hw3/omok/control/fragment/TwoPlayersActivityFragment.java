package edu.utep.cs.cs4330.hw3.omok.control.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.utep.cs.cs4330.hw3.omok.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TwoPlayersActivityFragment extends Fragment {

    public TwoPlayersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two_players, container, false);
    }
}
