package com.example.tugas5_altrariqwelfareyubaidi_124190054;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userdatabase.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table formulir(no integer primary key,nama text null,telp null,email text null,alamat text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO formulir(no,nama,telp,email,alamat) VALUES ('1001','Altrariq Yubaidi','0857111','altra@mail.com','Yogyakarta');";
        db.execSQL(sql);
        }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    }
    }
