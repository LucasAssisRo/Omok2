package edu.utep.cs.cs4330.hw3.omok.control.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.activity.GameActivity;
import edu.utep.cs.cs4330.hw3.omok.control.activity.OnePlayerActivity;
import edu.utep.cs.cs4330.hw3.omok.model.Computer;
import edu.utep.cs.cs4330.hw3.omok.model.Human;
import edu.utep.cs.cs4330.hw3.omok.model.StrategyRandom;
import edu.utep.cs.cs4330.hw3.omok.model.StrategySmart;

/**
 * A placeholder fragment containing a simple view.
 */
public class OnePlayerFragment extends Fragment {
    private EditText editTextPlayerOneName;
    private RadioButton radioButtonRandom;
    private RadioButton radioButtonSmart;
    private Button buttonNewGame;

    public OnePlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_player, container, false);
        editTextPlayerOneName = (EditText) view.findViewById(R.id.editTextPlayerOneName);
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
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OnePlayerActivity) getActivity()).startGame();
                editTextPlayerOneName.setFocusable(false);
            }
        });
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

    @Override
    public void onResume() {
        super.onResume();
        if(((Computer) ((GameActivity) getActivity()).
                getOmokGame().getPlayers()[1]).getStrategyMode() instanceof StrategyRandom)
            radioButtonRandom.setChecked(true);
        else
            radioButtonSmart.setChecked(true);
        editTextPlayerOneName.setText(((Human)(((GameActivity) getActivity()).getOmokGame().getPlayers()[0])).getName());
        if(((GameActivity) getActivity()).getOmokGame().isGameRunning()){
            editTextPlayerOneName.setFocusable(false);
        }
    }

    public EditText getEditTextPlayerOneName() {
        return editTextPlayerOneName;
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
