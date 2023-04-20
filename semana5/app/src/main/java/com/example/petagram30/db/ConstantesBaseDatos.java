package com.example.petagram30.db;

public class ConstantesBaseDatos {


    public static final String DATABASE_NAME            = "mascotas";
    public static final int DATABASE_VERSION            = 1;
    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";

    //////////////////////////////////////////////////
    public static final String TABLE_LIKES_MASCOTA      = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID   = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES  = "numero_likes";

    //////////////////////////////////////////////
    public static final String TABLA_ULTIMOS_CINCO_LIKES = "ultimos_cinco_likes";
    public static final String TABLE_ULTIMOS_CINCO_ID   = "id";
    public static final String TABLE_ULTIMOS_CINCO_ID_MASCOTA   = "id_ultimos_cinco_mascota";
    public static final String TABLE_ULTIMOS_CINCO_NOMBRE = "nombre";
    public static final String TABLE_ULTIMOS_CINCO_FOTO = "foto";

}

