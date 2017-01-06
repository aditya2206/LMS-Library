package com.adsol.lmslibrary.lms_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by adityasarma on 19/11/16.
 */

public class Issuedbooks extends SQLiteOpenHelper {

    public static final String TAG = DbLibrarians.class.getSimpleName();
    public static final String DB_NAME="Issuedbooks.db";
    public static final int DB_VERSION=1;

    public static final String USER_TABLE="Books";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_STUDENTNAME="_studentname";
    public static final String COLUMN_STUDENTID ="_studentid";
    public static final String COLUMN_BOOK="_book";
    public static final String COLUMN_STUDENTCONTACT="_contact";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("

            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_STUDENTNAME + " TEXT,"
            + COLUMN_STUDENTID + " TEXT,"
            + COLUMN_BOOK + " TEXT,"
            + COLUMN_STUDENTCONTACT + " INTEGER) ;";

    public Issuedbooks(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void issue(String studentname,String studentid,String book,String studentcontact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put(COLUMN_STUDENTNAME, studentname);
        contentValues.put(COLUMN_STUDENTID, studentid);
        contentValues.put(COLUMN_BOOK, book);
        contentValues.put(COLUMN_STUDENTCONTACT, studentcontact);

        long id =db.insert(USER_TABLE,null,contentValues);

        Log.d(TAG,"Book inserted" + id);


    }


    public ArrayList issuedBookslist(){

        ArrayList arrayList = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "select * from " + USER_TABLE;
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        int i= 1;
        while (cursor.isAfterLast() == false){
            arrayList.add("                        Issed Book "+i+" Details");
            arrayList.add("Student Name:- "+cursor.getString(cursor.getColumnIndex(COLUMN_STUDENTNAME)));
            arrayList.add("Student ID:- "+cursor.getString(cursor.getColumnIndex(COLUMN_STUDENTID)));
            arrayList.add("Book Name:- "+cursor.getString(cursor.getColumnIndex(COLUMN_BOOK)));
            arrayList.add("Student Contact :- "+cursor.getString(cursor.getColumnIndex(COLUMN_STUDENTCONTACT)));
            cursor.moveToNext();
            i++;

        }
        return arrayList;
    }

    public boolean returnbook(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE, COLUMN_STUDENTID +  "='" + name +"' ;", null) > 0;

    }

}
