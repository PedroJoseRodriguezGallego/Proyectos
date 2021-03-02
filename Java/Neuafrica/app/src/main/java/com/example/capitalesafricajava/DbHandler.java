package com.example.capitalesafricajava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHandler extends SQLiteOpenHelper
{
    private static final String TABLE_PAISES = "paises";
    private static final String KEY_ID = "id";
    private static final String KEY_PAIS = "pais";
    private static final String KEY_CAPITAL = "capital";

    public DbHandler(Context context, String dbName, int dbVersion)
    {
        super(context,dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PAISES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PAIS + " TEXT,"
                + KEY_CAPITAL + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAISES);
        onCreate(db);
    }

    public void resetear()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAISES);
        onCreate(db);
    }

    void insertarPais(Pais pais)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_ID, pais.getId());
        cValues.put(KEY_PAIS, pais.getPais());
        cValues.put(KEY_CAPITAL, pais.getCapital());

        db.insert(TABLE_PAISES,null, cValues);
        db.close();
    }


    public Pais obtenerPaisPorID(int paisID)
    {
        Pais paisEncontrado = new Pais();

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_PAISES, new String[]{KEY_ID, KEY_PAIS, KEY_CAPITAL}, KEY_ID + "=?",new String[]{String.valueOf(paisID)},null, null, null, null);


            if (cursor.moveToFirst())
            {
                cursor.moveToFirst();

                paisEncontrado.setId(cursor.getInt(0));
                paisEncontrado.setPais(cursor.getString(1));
                paisEncontrado.setCapital(cursor.getString(2));
            }
                else
                {
                    paisEncontrado.setPais("error");
                }

            cursor.close();
            db.close();

        return paisEncontrado;
    }

    public Pais obtenerPaisPorNombre(String paisNombre)
    {
        Pais paisEncontrado = new Pais();

        if(paisNombre != null)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_PAISES, new String[]{KEY_ID, KEY_PAIS, KEY_CAPITAL}, KEY_PAIS + "=?",new String[]{paisNombre},null, null, null, null);

            if (cursor.moveToFirst())
            {
                cursor.moveToFirst();

                paisEncontrado.setId(cursor.getInt(0));
                paisEncontrado.setPais(cursor.getString(1));
                paisEncontrado.setCapital(cursor.getString(2));
            }

            cursor.close();
            db.close();
        }

        return paisEncontrado;
    }

    public int obtenerTamano()
    {
        int tamano = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PAISES;
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            tamano++;
        }

        cursor.close();
        db.close();

        return tamano;
    }

    public void eliminarPais(String pais)
    {
        if(pais != null)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_PAISES, new String[]{KEY_ID, KEY_PAIS, KEY_CAPITAL}, KEY_PAIS + "=?",new String[]{pais},null, null, null, null);

            if(cursor.moveToFirst())
            {
                int id = Integer.parseInt(cursor.getString(0));
                db.delete(TABLE_PAISES, KEY_ID + " = ?",new String[]{String.valueOf(id)});
            }

            cursor.close();
            db.close();
        }

    }

}