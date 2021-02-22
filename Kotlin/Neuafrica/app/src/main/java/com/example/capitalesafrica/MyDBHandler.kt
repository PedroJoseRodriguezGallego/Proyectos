package com.example.capitalesafrica

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHandler(context: Context, name: String?,factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version)
{
    private val DATABASE_VERSION = 1
    private val DATABASE_NAME = "neuafrica"
    val TABLE_PAISES = "paises"
    val COLUMN_ID = "id"
    val COLUMN_PAIS = "pais"
    val COLUMN_CAPITAL = "capital"


    override fun onCreate(db: SQLiteDatabase)
    {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_PAISES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_PAIS
                + " TEXT," + COLUMN_CAPITAL + " TEXT" + ")")

        db.execSQL(CREATE_PRODUCTS_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,  newVersion: Int)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAISES)
        onCreate(db)
    }


    fun resetearTabla()
    {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAISES)
        onCreate(db)
    }


    fun anadirPais(pais: Pais)
    {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_ID, pais.id)
        values.put(COLUMN_PAIS, pais.pais)
        values.put(COLUMN_CAPITAL, pais.capital)

        db.insert(TABLE_PAISES, null, values)

        db.close()
    }


    fun encontrarPaisPorNombre(pais: String): Pais?
    {
        val db = this.writableDatabase
        val query ="SELECT * FROM $TABLE_PAISES WHERE $COLUMN_PAIS =  \"$pais\""
        val cursor = db.rawQuery(query, null)
        var pais: Pais? = null

        if (cursor.moveToFirst())
        {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val nombrePais = cursor.getString(1)
            val capital = cursor.getString(2)
            pais = Pais(id, nombrePais, capital)
        }

        cursor.close()
        db.close()

        return pais
    }


    fun encontrarPaisPorID(id: Int): Pais?
    {
        val db = this.writableDatabase
        val query ="SELECT * FROM $TABLE_PAISES WHERE $COLUMN_ID =  \"$id\""
        val cursor = db.rawQuery(query, null)
        var pais: Pais? = null

        if (cursor.moveToFirst())
        {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val nombrePais = cursor.getString(1)
            val capital = cursor.getString(2)
            pais = Pais(id, nombrePais, capital)
        }

        cursor.close()
        db.close()

        return pais
    }


    fun obtenerTamanoBBDD(): Int
    {
        val db = this.writableDatabase
        var tamano = 0
        val query = "SELECT * FROM " + TABLE_PAISES
        val cursor = db.rawQuery(query, null)

        while(cursor.moveToNext())
        {
            tamano++
        }

        cursor.close()
        db.close()

        return tamano
    }


    fun borrarPais(pais: String): Boolean
    {
        var result = false
        val db = this.writableDatabase
        val query ="SELECT * FROM $TABLE_PAISES WHERE $COLUMN_PAIS = \"$pais\""

        val cursor = db.rawQuery(query, null)

        if(cursor.moveToFirst())
        {
            val id = Integer.parseInt(cursor.getString(0))
            db.delete(TABLE_PAISES, COLUMN_ID + " = ?",arrayOf(id.toString()))
            result = true
        }

        cursor.close()
        db.close()

        return result
    }
}