package com.zzz.creatdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zzz.creatdb.dao.ContactInfoDao;

import static com.zzz.creatdb.R.id.et_name;
import static com.zzz.creatdb.R.id.et_phone;

public class MainActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_phone;
    private ContactInfoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.找到控件
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        //2.新增Dao方法
        dao = new ContactInfoDao(this);
    }

    public void delete(View view) {
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(MainActivity.this, "Please input your value", Toast.LENGTH_LONG).show();
            return;
        } else {
            dao.delete(name);
            Toast.makeText(MainActivity.this, "Delete success", Toast.LENGTH_LONG).show();
        }
    }

    public void update(View view) {
        String name = et_name.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)) {
            Toast.makeText(MainActivity.this, "Please input your value", Toast.LENGTH_LONG).show();
            return;
        } else {
            dao.update(phone, name);
            Toast.makeText(MainActivity.this, "Update success", Toast.LENGTH_LONG).show();
        }
    }

    public void query(View view) {
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(MainActivity.this, "Please input your value", Toast.LENGTH_LONG).show();
            return;
        } else {
            String phone = dao.query(name);
            Toast.makeText(MainActivity.this, "the phone number is : " + phone, Toast.LENGTH_LONG).show();
        }
    }

    public void add(View view) {
        String name = et_name.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)) {
            Toast.makeText(MainActivity.this, "Please input your value", Toast.LENGTH_LONG).show();
            return;
        } else {
            dao.add(name, phone);
            Toast.makeText(MainActivity.this, "Add success", Toast.LENGTH_LONG).show();
        }
    }

}
