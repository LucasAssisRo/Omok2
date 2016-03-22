package edu.utep.cs.cs4330.hw3.omok.control.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import edu.utep.cs.cs4330.hw3.omok.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class OnePlayerActivityFragment extends Fragment {
    private EditText editTextPlayerOne;

    public OnePlayerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_player, container, false);
        editTextPlayerOne = (EditText) view.findViewById(R.id.editTextPlayerOneName);

        return view;
    }
}
