package edu.utep.cs.cs4330.hw3.omok.control.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.activity.GameActivity;
import edu.utep.cs.cs4330.hw3.omok.model.Computer;
import edu.utep.cs.cs4330.hw3.omok.model.StrategyRandom;
import edu.utep.cs.cs4330.hw3.omok.model.StrategySmart;

/**
 * A placeholder fragment containing a simple view.
 */
public class OnePlayerActivityFragment extends Fragment {
    private EditText editTextPlayerOne;
    private RadioButton radioButtonRandom;
    private RadioButton radioButtonSmart;
    private Button buttonNewGame;

    public OnePlayerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_player, container, false);
        editTextPlayerOne = (EditText) view.findViewById(R.id.editTextPlayerOneName);
        radioButtonRandom = (RadioButton) view.findViewById(R.id.radioButtonRandom);
        radioButtonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        radioButtonSmart = (RadioButton) view.findViewById(R.id.radioButtonSmart);
        radioButtonSmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        buttonNewGame = (Button) view.findViewById(R.id.buttonNewGame);
        return view;
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonRandom:
                if (checked) {
                    ((Computer) ((GameActivity) getActivity()).getOmokGame()
                            .getPlayers()[1]).setStrategyMode(new StrategyRandom());
                }
                break;
            case R.id.radioButtonSmart:
                if (checked) {
                    ((Computer) ((GameActivity) getActivity()).getOmokGame()
                            .getPlayers()[1]).setStrategyMode(new StrategySmart());
                }
                break;
        }
    }

    public EditText getEditTextPlayerOne() {
        return editTextPlayerOne;
    }

    public RadioButton getRadioButtonRandom() {
        return radioButtonRandom;
    }

    public RadioButton getRadioButtonSmart() {
        return radioButtonSmart;
    }

    public Button getButtonNewGame() {
        return buttonNewGame;
    }
}
