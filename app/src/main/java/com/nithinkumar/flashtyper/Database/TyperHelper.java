package com.nithinkumar.flashtyper.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by nithinkumar on 6/24/17.
 */

public class TyperHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String DATABASE_NAME = "typerScoreHistory.db";

    public TyperHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String test = "create table " + TyperDBSchema.TyperTableName.NAME +
                "("
                + TyperDBSchema.Columns.ID + " integer primary key autoincrement, "
                + TyperDBSchema.Columns.DATE + " text not null, "
                + TyperDBSchema.Columns.SCORE + " text not null); ";
        db.execSQL(test);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(TyperHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TyperDBSchema.TyperTableName.NAME);
        onCreate(db);
    }

}
