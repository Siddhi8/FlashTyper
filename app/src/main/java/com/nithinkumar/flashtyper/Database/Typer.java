package com.nithinkumar.flashtyper.Database;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nithinkumar on 6/24/17.
 */

public class Typer {

    private long mId;
    private Date mDate;
    private long mScore;


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getScore() {
        return mScore;
    }

    public void setScore(long score) {
        mScore = score;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
