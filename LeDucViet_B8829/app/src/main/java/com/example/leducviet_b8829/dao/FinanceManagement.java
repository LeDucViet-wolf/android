package com.example.leducviet_b8829.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leducviet_b8829.entity.Finance;

import java.util.ArrayList;
import java.util.List;

public class FinanceManagement implements IFinanceDAO {
    private SQLiteDatabase mDB;

    public FinanceManagement(Context ctx) {
        DatabaseHelper helper = new DatabaseHelper(ctx);
        mDB = helper.getWritableDatabase();
    }

    @Override
    public List<Finance> select() {
        String sql = "SELECT * FROM tblFinance";
        List<Finance> list = new ArrayList<>();
        Cursor c = mDB.rawQuery(sql, null);
        while (c.moveToNext()) {
            @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
            @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
            @SuppressLint("Range") String money = c.getString(c.getColumnIndex("money"));

            Finance finance = new Finance(id, name, Double.parseDouble(money));
            list.add(finance);
        }
        return list;
    }

    @Override
    public Finance selectById(int id) {
        String sql = "SELECT * FROM tblFinance WHERE id = ?";
        Cursor c = mDB.rawQuery(sql, new String[]{String.valueOf(id)});
        while (c.moveToNext()) {
            @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
            @SuppressLint("Range") String money = c.getString(c.getColumnIndex("money"));

            Finance finance = new Finance(id, name, Double.parseDouble(money));
            return finance;
        }
        return null;
    }

    @Override
    public boolean insert(Finance f) {
        ContentValues cv = new ContentValues();
        cv.put("name", f.getName());
        cv.put("money", f.getMoney());
        long newId = mDB.insert("tblFinance", null, cv);
        if (newId > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        long newId = mDB.delete("tblFinance", "id =" + id, null);
        if (newId > 0) return true;
        return false;
    }
}
