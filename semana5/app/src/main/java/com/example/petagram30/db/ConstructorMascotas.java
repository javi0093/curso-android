package com.example.petagram30.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram30.R;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarSeisMascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosUltimosCinco(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerUltimosCinco();
    }

    public void insertarSeisMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "pepa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "juana isabel");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "luis enrrique");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "marco aurelio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro5);

        db.insertarMascota(contentValues);
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "maría luisa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.g4657_4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "carlos fernando");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro3);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public void insertarUltimosCinco(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ULTIMOS_CINCO_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());
        db.insertarUltimosCinco(contentValues);
    }

    public ArrayList<Mascota> obtenerUltimosCinco(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerUltimosCinco();

    }
}
