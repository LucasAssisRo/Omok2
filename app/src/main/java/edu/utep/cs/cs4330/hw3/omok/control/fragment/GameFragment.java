package edu.utep.cs.cs4330.hw3.omok.control.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.activity.GameActivity;
import edu.utep.cs.cs4330.hw3.omok.model.Board;
import edu.utep.cs.cs4330.hw3.omok.model.Coordinates;
import edu.utep.cs.cs4330.hw3.omok.model.Human;
import edu.utep.cs.cs4330.hw3.omok.model.OmokGame;
import edu.utep.cs.cs4330.hw3.omok.model.Player;
import edu.utep.cs.cs4330.hw3.omok.view.BoardView;

public class GameFragment extends Fragment {
    private BoardView boardView;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        boardView = (BoardView) v.findViewById(R.id.board_view);
        boardView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                OmokGame omokGame = ((GameActivity) getActivity()).getOmokGame();
                if (omokGame.isGameRunning()) {
                    int x, y;
                    int stepX, stepY;
                    stepX = boardView.getWidth() / 9;
                    stepY = boardView.getHeight() / 9;
                    x = (int) (event.getX() / stepX);
                    if (event.getX() % stepX > stepX / 2) {
                        x++;
                    }
                    y = (int) (event.getY() / stepY);
                    if (event.getY() % stepY > stepY / 2) {
                        y++;
                    }
                    omokGame.placeStone(new Coordinates(x, y));
                    if (!omokGame.isGameRunning()) {
                        boardView.invalidate();
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        Player player = omokGame.getCurrentPlayer();
                        if (player instanceof Human)
                            builder.setMessage(((Human) player).getName() + getResources().getString(R.string.win_message));
                        else
                            builder.setMessage(getResources().getString(R.string.loss_message));
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    boardView.updateBoard(omokGame.getBoard().getBoard());
                    boardView.invalidate();
                    return true;
                }
                return false;
            }
        });
        return v;
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }
}
