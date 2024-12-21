package me.bingyue.IceCore.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import android.util.Log;

import me.bingyue.IceCore.SQLite.DatabaseHelper;
public class Updata {
    public static void updateValue(String name, Integer value) {
        String FIXED_PATH = "/data/data/me.bingyue.IceCore/databases/app_config.db";
        SQLiteDatabase db = null;
        try {
            File dbFile = new File(FIXED_PATH);
            if (!dbFile.exists()) {
                Log.e("DatabaseHelper", "Database file not found at: " + FIXED_PATH);
                return;
            }

            db = SQLiteDatabase.openOrCreateDatabase(FIXED_PATH, null);

            // 检查该 name 是否已经存在
            boolean exists = Search.check_name(name);
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_ID, name);
            values.put(DatabaseHelper.COLUMN_NAME, value);

            // 如果记录已存在，则更新；如果记录不存在，则插入
            if (exists) {
                int rowsAffected = db.update(DatabaseHelper.TABLE_NAME, values, DatabaseHelper.COLUMN_ID + "=?", new String[]{name});
                if (rowsAffected == 0) {
                    Log.w("DatabaseHelper", "Update failed for: " + name);
                }
            } else {
                db.insert(DatabaseHelper.TABLE_NAME, null, values);
            }

        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error updating value", e);
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }
}

