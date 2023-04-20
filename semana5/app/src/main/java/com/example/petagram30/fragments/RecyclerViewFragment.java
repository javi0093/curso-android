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
import com.example.petagram30.presentador.IRecyclerViewFragmentPresenter;
import com.example.petagram30.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {
    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

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
         presenter = new RecyclerViewFragmentPresenter(this, getContext());

         return v;

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(arrayListMascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}