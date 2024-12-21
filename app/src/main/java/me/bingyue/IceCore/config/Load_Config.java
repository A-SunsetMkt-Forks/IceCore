package me.bingyue.IceCore.config;

import static me.bingyue.IceCore.config.Search.queryDataByName;

import android.content.ContentValues;
import android.content.Context;
import java.io.File;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.bingyue.IceCore.SQLite.DatabaseHelper;
import android.content.res.AssetManager;

public class Load_Config {

    private static Context context = null;

    public Load_Config(Context context) throws ClassNotFoundException, NullPointerException, IllegalAccessException, IOException {
        this.context = context;
        loading();
    }

    public static boolean getSQLFile() {
        File dbFile = context.getDatabasePath("app_config.db");
        return dbFile.exists();
    }


    public static void loading() throws IOException, ClassNotFoundException, IllegalAccessException {
        Class<?> configClass = Class.forName("me.bingyue.IceCore.config.Config");
        Field[] fields = configClass.getDeclaredFields();
        if(!getSQLFile()){
            copy_sql();
            for (Field field: fields){
                insertData(field.getName(), Boolean.compare(field.getBoolean(null), false));
            }
        }else{
            for (Field field : fields) {
                if (field.getType() == boolean.class && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    field.set(null, queryDataByName(field.getName()));
                }
            }
        }
    }


    public static void insertData(String name, Integer value) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ID, name);
        values.put(DatabaseHelper.COLUMN_NAME, value);

        db.insert(DatabaseHelper.TABLE_NAME, null, values);
        db.close();
    }


    public static void copy_sql() throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream in = null;
        OutputStream out = null;
        in = assetManager.open("app_config.db");
        out = Files.newOutputStream(context.getDatabasePath("app_config.db").toPath());
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.flush();
    }

}
