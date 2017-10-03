package com.nithinkumar.flashtyper.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nithinkumar.flashtyper.Activity.ReportCardActivity;
import com.nithinkumar.flashtyper.Activity.ScoreHistoryActivity;
import com.nithinkumar.flashtyper.R;


public class StartFargment extends Fragment {

    LinearLayout startButton;
    LinearLayout scoreBoard;

    private OnFragmentInteractionListener mListener;

    public StartFargment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    private static final String ARG_LAYOUT_NUMBER = "Layout Number";

    public static StartFargment newInstance(int layoutNumber) {
        StartFargment fragment = new StartFargment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_NUMBER, layoutNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start_fargment, container, false);

        startButton = (LinearLayout) v.findViewById(R.id.game_start);
        scoreBoard = (LinearLayout) v.findViewById(R.id.game_score_board);

        final ViewGroup transitionsContainer = (ViewGroup) v.findViewById(R.id.testing);
        mListener = (OnFragmentInteractionListener) v.getContext();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                mListener.onFragmentInteraction();
            }
        });

        scoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScoreHistoryActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
