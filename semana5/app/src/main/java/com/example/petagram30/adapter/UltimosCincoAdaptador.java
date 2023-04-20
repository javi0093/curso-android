package com.example.petagram30.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram30.R;
import com.example.petagram30.db.ConstructorMascotas;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;


public class UltimosCincoAdaptador extends RecyclerView.Adapter<UltimosCincoAdaptador.UltimasCincoViewHolder> {

    ArrayList<Mascota> arrayListMascotas;
    Activity activity;

    public UltimosCincoAdaptador(ArrayList<Mascota> arraylistUltimasCinco, Activity activity) {
        this.arrayListMascotas = arraylistUltimasCinco;
        this.activity= activity;
    }

    @NonNull
    @Override
    public UltimasCincoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_top5, parent, false);
        return new UltimosCincoAdaptador.UltimasCincoViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull UltimasCincoViewHolder holder, int position) {
        final Mascota mascota = arrayListMascotas.get(position);
        holder.imgFotoTop.setImageResource(mascota.getFoto());
        holder.tvNombreCVTop.setText(mascota.getNombre());

    }

    @Override
    public int getItemCount() {
        return arrayListMascotas.size();
    }

    public static class UltimasCincoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoTop;
        private TextView tvNombreCVTop;

        public UltimasCincoViewHolder(View itemView) {
            super(itemView);
            imgFotoTop      = (ImageView) itemView.findViewById(R.id.imgFotoTop);
            tvNombreCVTop   = (TextView) itemView.findViewById(R.id.tvNombreCVTop);
        }
    }

}
