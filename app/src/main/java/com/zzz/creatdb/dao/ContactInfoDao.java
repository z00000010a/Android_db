package com.zzz.creatdb.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zzz.creatdb.MyDBOpenHelp;

/**
 * Created by Ares on 2017/11/7.
 */

public class ContactInfoDao {
    public final MyDBOpenHelp helper;

    public ContactInfoDao(Context context){
        helper = new MyDBOpenHelp(context);
    }

    public void add(String name, String phone){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into contactinfo (name,phone) values (?,?);",new Object[]{name,phone});
        System.out.println("insert");
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from contactinfo where name = ?;",new Object[]{name});
        db.close();
    }

    public void update(String newphone, String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update contactinfo set phone = ? where name = ?;", new Object[]{newphone, name});
        // 记得关闭数据库释放资源
        db.close();
    }
    public String query(String name){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select phone from contactinfo where name = ?;", new String[]{name});
        String phone = null;
        if (cursor.moveToNext()){
            phone = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return phone;

    }
}
