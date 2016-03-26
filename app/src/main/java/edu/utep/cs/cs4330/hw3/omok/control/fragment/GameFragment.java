package edu.utep.cs.cs4330.hw3.omok.control.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.utep.cs.cs4330.hw3.omok.R;
import edu.utep.cs.cs4330.hw3.omok.control.activity.GameActivity;
import edu.utep.cs.cs4330.hw3.omok.model.Board;
import edu.utep.cs.cs4330.hw3.omok.model.Computer;
import edu.utep.cs.cs4330.hw3.omok.model.Coordinates;
import edu.utep.cs.cs4330.hw3.omok.model.Human;
import edu.utep.cs.cs4330.hw3.omok.model.OmokGame;
import edu.utep.cs.cs4330.hw3.omok.model.Player;
import edu.utep.cs.cs4330.hw3.omok.view.BoardView;

public class GameFragment extends Fragment {
    private BoardView boardView;
    private TextView textViewTurn;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        textViewTurn = (TextView) v.findViewById(R.id.textViewTurn);
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
                    Coordinates playCoordinates;
                    Player currentPlayer = omokGame.getCurrentPlayer();
                    Player nextPlayer = omokGame.getNextPlayer();
                    if (currentPlayer instanceof Computer)
                        playCoordinates = ((Computer) omokGame.getCurrentPlayer()).findCoordinates(omokGame.getBoard().getBoard());
                    else
                        playCoordinates = new Coordinates(x, y);
                    if (omokGame.placeStone(playCoordinates)) {
                        boardView.invalidate();
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        if (currentPlayer instanceof Human) {
                            builder.setMessage(((Human) currentPlayer).getName() + getResources().getString(R.string.win_message));
                            ((Human) currentPlayer).addWin();
                            if (nextPlayer instanceof Human)
                                ((Human) nextPlayer).addLoss();
                        } else {
                            builder.setMessage(getResources().getString(R.string.loss_message));
                            ((Human) omokGame.getPlayers()[0]).addLoss();
                        }
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    if (omokGame.getTurn() == 0)
                        textViewTurn.setText(R.string.player_one_turn);
                    else
                        textViewTurn.setText(R.string.player_two_turn);
                    boardView.updateBoard(omokGame.getBoard().getBoard());
                    boardView.invalidate();
                    return true;
                }
                return false;
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        boardView.updateBoard(((GameActivity) getActivity()).getOmokGame().getBoard().getBoard());
        if (((GameActivity) getActivity()).getOmokGame().getTurn() == 0)
            textViewTurn.setText(R.string.player_one_turn);
        else
            textViewTurn.setText(R.string.player_two_turn);
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }
}
