package com.nithinkumar.flashtyper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.nithinkumar.flashtyper.Utils.Converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.nithinkumar.flashtyper.Database.TyperDBSchema.*;
import static java.util.UUID.fromString;

/**
 * Created by nithinkumar on 6/24/17.
 */

public class TyperDataSource {

    private SQLiteDatabase database;
    private TyperHelper dbHelper;
    Date dateCursor;

    private String[] allColumns = {
            Columns.ID,
            Columns.DATE,
            Columns.SCORE
    };

    public TyperDataSource(Context context) {
        dbHelper = new TyperHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Typer createTyperDetails(long score, Date date) {
        ContentValues values = new ContentValues();
        values.put(Columns.DATE, Converters.dateToString(date));
        values.put(Columns.SCORE, String.valueOf(score));

        long insertId = database.insert(TyperTableName.NAME, null, values);
        Cursor cursor = database.query(TyperTableName.NAME,
                allColumns, Columns.ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Typer newTperValues = cursorToTyperDetails(cursor);
        cursor.close();

        return newTperValues;
    }

    public Typer updateTyperDetails(Typer typerDetails) {
        ContentValues values = new ContentValues();
        values.put(Columns.DATE, String.valueOf(typerDetails.getDate()));
        values.put(Columns.SCORE, String.valueOf(typerDetails.getScore()));
        database.update(TyperTableName.NAME, values, Columns.ID + " = " + typerDetails.getId(), null);
        return typerDetails;
    }

    private Typer cursorToTyperDetails(Cursor cursor) {
        Typer typerDetails = new Typer();
        typerDetails.setId(cursor.getLong(0));
        String dateString = cursor.getString(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            typerDetails.setDate(dateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        typerDetails.setScore(cursor.getLong(2));
        return typerDetails;
    }

    public List<Typer> getTyperDetails() {
        List<Typer> type = new ArrayList();

        open();
        Cursor cursor = database.query(TyperTableName.NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Typer count = cursorToTyperDetails(cursor);
            type.add(count);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return type;

    }


}
