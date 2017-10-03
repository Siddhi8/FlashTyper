package com.nithinkumar.flashtyper.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nithinkumar.flashtyper.Activity.ScoreHistoryActivity;
import com.nithinkumar.flashtyper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportCardFragment extends Fragment {

    TextView mFinalScore;
    LinearLayout mPlayAgain;
    LinearLayout mScoreBoard;

    public static String mScore;

    public ReportCardFragment() {
        // Required empty public constructor
    }

    private static final String ARG_LAYOUT_NUMBER = "Layout Number";

    private static final String ARG_SCORE = "Score";

    public static ReportCardFragment newInstance(int layoutNumber, String score) {
        ReportCardFragment fragment = new ReportCardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_NUMBER, layoutNumber);
        args.putString(ARG_SCORE, score);
        fragment.setArguments(args);
        mScore = score;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report_card, container, false);

        mFinalScore = (TextView) v.findViewById(R.id.final_score);
        mPlayAgain = (LinearLayout) v.findViewById(R.id.game_restart);
        mScoreBoard = (LinearLayout) v.findViewById(R.id.score_board);

        mFinalScore.setText(mScore);

        mPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.reportcard_main_layout, GameScreenFragment.newInstance(R.layout.fragment_game_screen));
                fragmentTransaction.commit();

            }
        });

        mScoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScoreHistoryActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
