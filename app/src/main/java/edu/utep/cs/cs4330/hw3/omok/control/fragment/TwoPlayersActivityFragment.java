package edu.utep.cs.cs4330.hw3.omok.control.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.activity.TwoPlayersActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class TwoPlayersActivityFragment extends Fragment {
    private EditText editTextPlayerOne;
    private EditText editTextPlayerTwo;
    private Button buttonNewGame;

    public TwoPlayersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_players, container, false);
        editTextPlayerOne = (EditText) view.findViewById(R.id.editTextPlayerOneName);
        editTextPlayerTwo = (EditText) view.findViewById(R.id.editTextPlayerTwoName);
        buttonNewGame = (Button) view.findViewById(R.id.buttonNewGame);
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TwoPlayersActivity)getActivity()).startGame();
            }
        });
        return view;
    }

    public EditText getEditTextPlayerOne() {
        return editTextPlayerOne;
    }

    public EditText getEditTextPlayerTwo() {
        return editTextPlayerTwo;
    }

    public Button getButtonNewGame() {
        return buttonNewGame;
    }
}
