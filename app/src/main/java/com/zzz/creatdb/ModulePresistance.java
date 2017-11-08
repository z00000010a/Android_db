package com.zzz.creatdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ares on 2017/11/7.
 */

public class ModulePresistance extends SQLiteOpenHelper {

    public ModulePresistance(Context context) {
        super(context, "Modules.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table Table_Modules ()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
