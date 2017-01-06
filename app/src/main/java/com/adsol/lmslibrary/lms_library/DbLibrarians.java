package com.adsol.lmslibrary.lms_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;



/**
 * Created by adityasarma on 04/11/16.
 */

public class DbLibrarians extends SQLiteOpenHelper {

    public static final String TAG = DbLibrarians.class.getSimpleName();
    public static final String DB_NAME="DbLibrarians.db";
    public static final int DB_VERSION=1;

    public static final String USER_TABLE="librarians";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_NAME="_name";
    public static final String COLUMN_PASSWORD ="_pass";
    public static final String COLUMN_EMPID="_empid";
    public static final String COLUMN_CONTACT="_contact";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("

            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_EMPID + " TEXT,"
            + COLUMN_CONTACT + " TEXT) ;";


    public DbLibrarians(Context context ) {
        super(context, DB_NAME, null , DB_VERSION);
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

    public boolean addlib(String name,String password,String empid,String contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_EMPID, empid);
        contentValues.put(COLUMN_CONTACT, contact);

        long id =db.insert(USER_TABLE,null,contentValues);

        Log.d(TAG,"User inserted" + id);

        return true;
    }

    public boolean getlib(String empid,String password){

        String selectQuery = "select * from " + USER_TABLE + " where "+
                COLUMN_EMPID + " = " +"'"+empid+"'" + " and " + COLUMN_PASSWORD + " = " + "'"+password+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        cursor.moveToFirst();
        if(cursor.getCount()>0){
            return true;
        }

            cursor.close();
            db.close();

            return false;


    }

    public ArrayList viewlib(){

        ArrayList arrayList = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "select * from " + USER_TABLE;
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        int i= 1;
        while (cursor.isAfterLast() == false){
            arrayList.add("                        Librarian "+i+" Details");
            arrayList.add("Name:- "+cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            arrayList.add("Employee ID:- "+cursor.getString(cursor.getColumnIndex(COLUMN_EMPID)));
            arrayList.add("Password:- "+cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
            arrayList.add("Contact No:- "+cursor.getString(cursor.getColumnIndex(COLUMN_CONTACT)));
            cursor.moveToNext();
            i++;

        }
     return arrayList;
    }

    public boolean deletelib(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE, COLUMN_NAME +  "='" + name +"' ;", null) > 0;

    }


}
