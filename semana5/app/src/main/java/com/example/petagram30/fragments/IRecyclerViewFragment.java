package com.example.petagram30.fragments;

import com.example.petagram30.adapter.MascotaAdaptador;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
