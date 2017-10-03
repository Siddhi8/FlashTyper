package com.nithinkumar.flashtyper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nithinkumar.flashtyper.Database.TyperDataSource;
import com.nithinkumar.flashtyper.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by nithinkumar on 6/24/17.
 */

public class ScoreHistoryAdapter extends RecyclerView.Adapter<ScoreHistoryAdapter.ScoreHistoryHolder>
{

    TyperDataSource mTyperDataSource;
    Context mContext;
    private LayoutInflater inflator;

    public ScoreHistoryAdapter(Context context)
    {
        inflator = LayoutInflater.from(context);
        this.mContext = context;
        mTyperDataSource = new TyperDataSource(context);
    }


    @Override
    public ScoreHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflator.inflate(R.layout.recycler_view_card, parent,false);
        ScoreHistoryHolder holder = new ScoreHistoryHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ScoreHistoryHolder holder, int position) {


        mTyperDataSource.open();
        long id = mTyperDataSource.getTyperDetails().get(position).getId();
        holder.mGameNumber.setText("Game " + id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String gameTime = dateFormat.format(mTyperDataSource.getTyperDetails().get(position).getDate());
        holder.mDate.setText(gameTime);

        holder.mScore.setText(String.valueOf(mTyperDataSource.getTyperDetails().get(position).getScore()));
        mTyperDataSource.close();
    }

    @Override
    public int getItemCount() {
        return mTyperDataSource.getTyperDetails().size();
    }


    class ScoreHistoryHolder extends RecyclerView.ViewHolder
    {
        TextView mGameNumber;
        TextView mDate;
        TextView mScore;
        public ScoreHistoryHolder(View itemView) {
            super(itemView);

            mGameNumber = (TextView) itemView.findViewById(R.id.game_number);
            mDate = (TextView) itemView.findViewById(R.id.game_time);
            mScore = (TextView) itemView.findViewById(R.id.game_score_final);

        }
    }
}
