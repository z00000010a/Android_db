package com.zzz.creatdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by Ares on 2017/11/6.
 */

public class MyDBOpenHelp extends SQLiteOpenHelper {

    public MyDBOpenHelp(Context context) {
        super(context,"zzzDB", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("OnCreate方法，数据库被创建了");
        db.execSQL("CREATE table contactinfo(id integer primary key autoincrement, name char(20), phone varchar(20)); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("OnUpgrade方法，数据库升级");
        //db.execSQL("alter table contactinfo add account varchar(20);");
    }
}
