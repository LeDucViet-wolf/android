package com.example.leducviet_b8829.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@androidx.annotation.Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tblFinance (\n" +
                "    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    Name VARCHAR (32) NOT NULL,\n" +
                "    Money DOUBLE NOT NULL CHECK (Money >= 0),\n" +
                ");\n";
        db.execSQL(sql);

        sql = "INSERT INTO tblFinance(Name, Money) VALUES ('Mua quần áo', 125000)";
        db.execSQL(sql);
        sql = "INSERT INTO tblFinance(Name, Money) VALUES ('Ăn sáng', 10000)";
        db.execSQL(sql);
        sql = "INSERT INTO tblFinance(Name, Money) VALUES ('Ăn trưa', 25000)";
        db.execSQL(sql);
        sql = "INSERT INTO tblFinance(Name, Money) VALUES ('Đưa gấu đi chơi', 312800)";
        db.execSQL(sql);
        sql = "INSERT INTO tblFinance(Name, Money) VALUES ('Nạp điện thoại', 5000)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
