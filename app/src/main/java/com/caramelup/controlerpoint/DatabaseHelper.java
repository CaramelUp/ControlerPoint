package com.caramelup.controlerpoint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fbuenod on 10/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public static final String DATABASE_NAME = "ControlerPoint";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE ="";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TB_Entrada (_id integer primary key autoincrement,  DataEntrada text not null, HoraEntrada text not null);");
        db.execSQL("create table TB_Saida (_id integer primary key autoincrement,  DataSaida text not null, HoraSaida text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("insert into TB_Entrada (DataEntrada, HoraEntrada) values ('25/11/2016', '15:15:15');");
    }
}
