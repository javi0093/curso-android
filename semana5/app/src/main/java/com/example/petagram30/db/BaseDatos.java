package com.example.petagram30.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " +ConstantesBaseDatos.TABLE_MASCOTAS + "("+
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";
//acá le mete un " " + antes de create table
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID+")"
                + ")"; //acá usa TABLE_MASCOTA_ID

        String queryCrearTablaCincoUltimos = "CREATE TABLE " + ConstantesBaseDatos.TABLA_ULTIMOS_CINCO_LIKES + "(" +
                ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID_MASCOTA  + " INTEGER, " +
                ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_FOTO + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID_MASCOTA + ") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID +")"
                + ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaCincoUltimos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS );
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA );
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_ULTIMOS_CINCO_LIKES );
        onCreate(db); // <-- esto no lo pone
    }
    ///////////////////////////////////////////////////////////
    //consulta a la base de datos
    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();

    }
    public void insertarUltimosCinco(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_ULTIMOS_CINCO_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" +mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Mascota> obtenerUltimosCinco() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_ULTIMOS_CINCO_LIKES +
                " ORDER BY " + ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID + " DESC LIMIT 5 ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }


}
