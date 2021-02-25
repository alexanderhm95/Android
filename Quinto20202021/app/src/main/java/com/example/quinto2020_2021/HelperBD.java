package com.example.quinto2020_2021;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class HelperBD extends SQLiteOpenHelper {

    public HelperBD(Context context,String  name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table docente (id integer PRIMARY KEY AUTOINCREMENT, cedula TEXT, apellidos TEXT, nombres TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void  insertar(String cedula,String apellidos, String nombres){
        ContentValues values= new ContentValues();
        values.put("cedula",cedula);
        values.put("apellidos",apellidos);
        values.put("nombres",nombres);
        this.getWritableDatabase().insert("docente",null,values);
    }
    public void  modificar(String cedula,String apellidos, String nombres){
        ContentValues values= new ContentValues();

        values.put("apellidos",apellidos);
        values.put("nombres",nombres);
        this.getWritableDatabase().update("docente",values,"cedula='"+cedula+"'",null);
    }

    public void  deleteall(String cedula,String apellidos, String nombres){

        this.getWritableDatabase().delete("docente",null,null);
    }
    public void  deleteselect(String cedula){
        ContentValues values= new ContentValues();
        this.getWritableDatabase().delete("docente","cedula='"+cedula+"'",null);
    }
    public String  listall(){
       String consulta="";
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM docente",null);
        if(cursor.moveToFirst()){
            do{
                String cedula=cursor.getString(cursor.getColumnIndex("cedula"));
                String apellidos=cursor.getString(cursor.getColumnIndex("apellidos"));
                String nombres=cursor.getString(cursor.getColumnIndex("nombres"));
                consulta+=cedula+" "+apellidos+" "+nombres+";\n";
            }while (cursor.moveToNext());
        }
        return consulta;
    }
    public String  listaselect(String cedulain){
        String consulta="";
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM docente where cedula='"+cedulain+"'",null);
        if(cursor.moveToFirst()){
            do{
                String cedula=cursor.getString(cursor.getColumnIndex("cedula"));
                String apellidos=cursor.getString(cursor.getColumnIndex("apellidos"));
                String nombres=cursor.getString(cursor.getColumnIndex("nombres"));
                consulta+=cedula+" "+apellidos+" "+nombres+";\n";
            }while (cursor.moveToNext());
        }
        return consulta;
    }
}