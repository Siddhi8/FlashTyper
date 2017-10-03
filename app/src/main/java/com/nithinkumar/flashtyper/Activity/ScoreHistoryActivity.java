package com.nithinkumar.flashtyper.Activity;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.games.Games;
import com.nithinkumar.flashtyper.Adapters.ScoreHistoryAdapter;
import com.nithinkumar.flashtyper.FTester;
import com.nithinkumar.flashtyper.R;

public class ScoreHistoryActivity extends BaseActivity implements FTester {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    ScoreHistoryAdapter mScoreHistoryAdapter;
    Toolbar mToolbar;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_sc);
        mToolbar.setTitle("ScoreBoard");
        setSupportActionBar(mToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_score);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mScoreHistoryAdapter = new ScoreHistoryAdapter(getBaseContext());
        mRecyclerView.setAdapter(mScoreHistoryAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_score_history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.challenge_friend:
                challengeFriend();
                return true;
            case R.id.rate_us:
                rateUs();
                return true;
            case R.id.leaderboard:
                rankings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void challengeFriend() {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Flash Typers");
            String sAux = "\nYour Friend wants to challenge you to beat his score in this application.\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=com.nithinkumar.flashtyper \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }



    public void rateUs() {
        Uri uri = Uri.parse("market://details?id=" + "com.nithinkumar.flashtyper");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + "com.nithinkumar.flashtyper")));
        }
    }

    @Override
    public void rankings() {

    }
}
