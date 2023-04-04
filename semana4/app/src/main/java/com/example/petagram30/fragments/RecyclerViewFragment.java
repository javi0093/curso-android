package com.example.petagram30.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram30.R;
import com.example.petagram30.adapter.MascotaAdaptador;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView listaMascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recycler_view, container, false);
         View v= inflater.inflate(R.layout.fragment_recycler_view,container,false);

         listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
         LinearLayoutManager llm = new LinearLayoutManager(getActivity());
         llm.setOrientation(LinearLayoutManager.VERTICAL);

         listaMascotas.setLayoutManager(llm);
         inicializarListaMascotas();
         inicializarAdaptador();

         return v;

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(arrayListMascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        arrayListMascotas = new ArrayList<Mascota>();
        arrayListMascotas.add(new Mascota("pepa", R.drawable.perro1, 5));
        arrayListMascotas.add(new Mascota("juana isabel", R.drawable.perro2, 4));
        arrayListMascotas.add(new Mascota("luis enrrique", R.drawable.perro4, 2));
        arrayListMascotas.add(new Mascota("marco aurelio", R.drawable.perro5, 1));
        // arrayListMascotas.add(new Mascota("maría luisa", R.drawable.g4657_4, 8));
        arrayListMascotas.add(new Mascota("carlos fernando", R.drawable.perro3, 3));
    }
}