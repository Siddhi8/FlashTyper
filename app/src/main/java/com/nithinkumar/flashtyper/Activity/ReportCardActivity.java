package com.nithinkumar.flashtyper.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nithinkumar.flashtyper.Fragments.GameScreenFragment;
import com.nithinkumar.flashtyper.Fragments.ReportCardFragment;
import com.nithinkumar.flashtyper.R;

public class ReportCardActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_card);

        String score = getIntent().getExtras().getString("Score");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.reportcard_main_layout, ReportCardFragment.newInstance(R.layout.fragment_report_card, score));
        fragmentTransaction.commit();
    }
}
