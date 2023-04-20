package com.example.petagram30.presentador;

import android.content.Context;

import com.example.petagram30.IRecyclerViewFavoritasView;
import com.example.petagram30.db.ConstructorMascotas;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewUltimosCincoPresenter implements IRecyclerViewUltimosCincoPresenter{
    private IRecyclerViewFavoritasView iRecyclerViewFavoritasView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public RecyclerViewUltimosCincoPresenter(IRecyclerViewFavoritasView iRecyclerViewFavoritasView, Context context) {
        this.iRecyclerViewFavoritasView = iRecyclerViewFavoritasView;
        this.context= context;
        obtenerUltimosCincoBaseDatos();
    }

    @Override
    public void obtenerUltimosCincoBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosUltimosCinco();
        mostrarUltimiosCinco();
    }

    @Override
    public void mostrarUltimiosCinco() {
        iRecyclerViewFavoritasView.inicializarAdaptadorRV(iRecyclerViewFavoritasView.crearAdaptador(mascotas));
        iRecyclerViewFavoritasView.generarLinaerLayoutVertical();
    }
}
