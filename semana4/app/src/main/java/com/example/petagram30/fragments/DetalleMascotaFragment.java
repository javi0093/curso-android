package com.example.petagram30.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram30.R;
import com.example.petagram30.adapter.FotosMiMascotaAdaptador;
import com.example.petagram30.adapter.MascotaAdaptador;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;


public class DetalleMascotaFragment extends Fragment {

    ArrayList<Mascota> miMascota;
    private RecyclerView gridFotos;

    public DetalleMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detalle_mascota, container, false);
        View v= inflater.inflate(R.layout.fragment_detalle_mascota,container,false);

        gridFotos = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        gridFotos.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        FotosMiMascotaAdaptador adaptador = new FotosMiMascotaAdaptador(miMascota, getActivity());
        gridFotos.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        miMascota = new ArrayList<Mascota>();
        miMascota.add(new Mascota( R.drawable.perro4, 5));
        miMascota.add(new Mascota( R.drawable.perro4, 2));
        miMascota.add(new Mascota( R.drawable.perro4, 4));
        miMascota.add(new Mascota( R.drawable.perro4, 6));
        miMascota.add(new Mascota( R.drawable.perro4, 5));
        miMascota.add(new Mascota( R.drawable.perro4, 2));
        miMascota.add(new Mascota( R.drawable.perro4, 4));
        miMascota.add(new Mascota( R.drawable.perro4, 6));
        miMascota.add(new Mascota( R.drawable.perro4, 8));
        miMascota.add(new Mascota( R.drawable.perro4, 3));
        miMascota.add(new Mascota( R.drawable.perro4, 7));
        miMascota.add(new Mascota( R.drawable.perro4, 10));
        miMascota.add(new Mascota( R.drawable.perro4, 33));
        miMascota.add(new Mascota( R.drawable.perro4, 123));



    }
}