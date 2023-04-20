package com.example.petagram30.presentador;

import android.content.Context;

import com.example.petagram30.db.ConstructorMascotas;
import com.example.petagram30.fragments.IRecyclerViewFragment;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
