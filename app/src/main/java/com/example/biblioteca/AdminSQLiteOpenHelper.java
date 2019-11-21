package com.example.biblioteca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase; // Importamos clase base de datos.
import android.database.sqlite.SQLiteOpenHelper; // Importamos clase OpenHelper.

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Database) {
        // Creando nuestra primera tabla con SQLite.
        Database.execSQL("CREATE TABLE libros(codigo int primary key, nombre text, precio float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
