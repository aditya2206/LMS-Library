package com.adsol.lmslibrary.lms_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ExpandableListView;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by adityasarma on 19/11/16.
 */

public class DBBooks extends SQLiteOpenHelper {



    public static final String TAG = DbLibrarians.class.getSimpleName();
    public static final String DB_NAME="DBBooks.db";
    public static final int DB_VERSION=1;

    public static final String USER_TABLE="Books";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_BOOKNAME="_bookname";
    public static final String COLUMN_AUTHORNAME ="_authorname";
    public static final String COLUMN_PUBLISHERNAME="_publishername";
    public static final String COLUMN_QUANTITY="_quantity";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("

            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_BOOKNAME + " TEXT,"
            + COLUMN_AUTHORNAME + " TEXT,"
            + COLUMN_PUBLISHERNAME + " TEXT,"
            + COLUMN_QUANTITY + " INTEGER) ;";


    public DBBooks(Context context) {
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

    public boolean addbook(String bookname,String authorname,String publishername,String quantity){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put(COLUMN_BOOKNAME, bookname);
        contentValues.put(COLUMN_AUTHORNAME, authorname);
        contentValues.put(COLUMN_PUBLISHERNAME, publishername);
        contentValues.put(COLUMN_QUANTITY, quantity);

        long id =db.insert(USER_TABLE,null,contentValues);

        Log.d(TAG,"Book inserted" + id);

        return true;
    }

    public ArrayList Bookslist(){

        ArrayList arrayList = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "select * from " + USER_TABLE;
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        int i= 1;
        while (cursor.isAfterLast() == false){
            arrayList.add("                          Book "+i+" Details");
            arrayList.add("Book Name:- "+cursor.getString(cursor.getColumnIndex(COLUMN_BOOKNAME)));
            arrayList.add("Author Name:- "+cursor.getString(cursor.getColumnIndex(COLUMN_AUTHORNAME)));
            arrayList.add("Publisher:- "+cursor.getString(cursor.getColumnIndex(COLUMN_PUBLISHERNAME)));
            arrayList.add("Quantity Available:-  "+cursor.getString(cursor.getColumnIndex(COLUMN_QUANTITY)));
            cursor.moveToNext();
            i++;

        }
        return arrayList;
    }

    public boolean getbook(String name){



        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + USER_TABLE + " where "+
                COLUMN_BOOKNAME + " = " +"'"+name+"'", null);

        cursor.moveToFirst();
        if(cursor.getCount()>0){
            return true;
        }

        cursor.close();
        db.close();

        return false;
    }


}


