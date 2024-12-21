package me.bingyue.IceCore.config;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import me.bingyue.IceCore.SQLite.DatabaseHelper;

import java.io.File;
import java.io.IOException;

public class Search {


    public static boolean queryDataByName(String name) throws IOException {
        String dbPath = "/data/data/me.bingyue.IceCore/databases/app_config.db";
        Integer value = 1;
        File dbFile = new File(dbPath);

        SQLiteDatabase db = null;
        Cursor cursor = null;

        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {name};
        String[] columns = {DatabaseHelper.COLUMN_NAME};

        cursor = db.query(DatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
        }
        if (cursor != null) cursor.close();
        if (db != null) db.close();
        return (value == 1);
    }

    public static boolean check_name(String name) throws IOException {
        String dbPath = "/data/data/me.bingyue.IceCore/databases/app_config.db";
        File dbFile = new File(dbPath);

        SQLiteDatabase db = null;
        Cursor cursor = null;

        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {name};
        String[] columns = {DatabaseHelper.COLUMN_NAME};

        cursor = db.query(DatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        if (cursor != null) cursor.close();
        if (db != null) db.close();
        return false;
    }
}
