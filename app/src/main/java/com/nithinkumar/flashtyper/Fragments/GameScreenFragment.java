package com.nithinkumar.flashtyper.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nithinkumar.flashtyper.Activity.ReportCardActivity;
import com.nithinkumar.flashtyper.Database.TyperDataSource;
import com.nithinkumar.flashtyper.Utils.Quotes;
import com.nithinkumar.flashtyper.R;
import com.nithinkumar.flashtyper.Utils.NGram;

import java.util.Date;


public class GameScreenFragment extends Fragment {

    EditText mGameBody;
    TextView mGameScore;
    TextView mGameTimer;
    TextView mGameQuote;
    Button mSubmitAdvance;
    int countScore;
    int leftTime;

    CountDownTimer countDownTimer;
    TyperDataSource mTyperDataSource;
    Quotes mQuotes;
    NGram mNGram;

    String test;

    public GameScreenFragment() {
        // Required empty public constructor
    }

    private static final String ARG_LAYOUT_NUMBER = "Layout Number";

    public static GameScreenFragment newInstance(int layoutNumber) {
        GameScreenFragment fragment = new GameScreenFragment();
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
        View v = inflater.inflate(R.layout.fragment_game_screen, container, false);

        mGameBody = (EditText) v.findViewById(R.id.game_body);
        mGameScore = (TextView) v.findViewById(R.id.game_score);
        mGameTimer = (TextView) v.findViewById(R.id.game_time);
        mGameQuote = (TextView) v.findViewById(R.id.game_quote);
        mGameQuote.setSelected(true);
        mSubmitAdvance = (Button) v.findViewById(R.id.submit_advance);

        mSubmitAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countScore == 100) {
                    countDownTimer.cancel();
                    int bonusScore = countScore + leftTime;
                    mGameScore.setText(String.valueOf(bonusScore));
                    finalTask();
                }
                else{
                    mSubmitAdvance.setActivated(false);
                }
            }
        });

        countScore = 0;

        mQuotes = new Quotes();
        test = mQuotes.getQuote();
        mGameQuote.setText(test);

        mNGram = new NGram();

        mGameBody.post(new Runnable() {
            public void run() {
                mGameBody.requestFocusFromTouch();
                InputMethodManager lManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                lManager.showSoftInput(mGameBody, 0);
            }
        });

        mTyperDataSource = new TyperDataSource(getContext());

        timerForGame();


        TextWatcher myTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float sc = mNGram.getDistance(test, String.valueOf(s)) * 100;
                countScore = (int) (sc);
                mGameScore.setText(String.valueOf(countScore));
            }
        };

        mGameBody.addTextChangedListener(myTextWatcher);

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

    public void updateDB() {
        mTyperDataSource.open();
        int finalScore = Integer.valueOf(mGameScore.getText().toString());
        Date mDate = new Date();
        mTyperDataSource.createTyperDetails(finalScore, mDate);
        mTyperDataSource.close();
    }

    public void finalTask() {
        Intent intent = new Intent(getContext(), ReportCardActivity.class);
        intent.putExtra("Score", mGameScore.getText());
        startActivity(intent);
        updateDB();
    }

    public void timerForGame()
    {

      countDownTimer  =  new CountDownTimer(35000, 1000) {

            public void onTick(long millisUntilFinished) {
                leftTime = (int) millisUntilFinished / 1000;
                mGameTimer.setText(String.valueOf((int) millisUntilFinished / 1000));
            }

            public void onFinish() {

                mGameTimer.setText("Done!");
                finalTask();
            }
        }.start();
    }
}
