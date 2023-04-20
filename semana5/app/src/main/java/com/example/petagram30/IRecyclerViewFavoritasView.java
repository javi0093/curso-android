package com.example.petagram30;

import com.example.petagram30.adapter.UltimosCincoAdaptador;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFavoritasView {

    public void generarLinaerLayoutVertical();

    public UltimosCincoAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (UltimosCincoAdaptador adaptador);
}
