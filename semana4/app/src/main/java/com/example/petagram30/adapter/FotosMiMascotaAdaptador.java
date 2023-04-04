package com.example.petagram30.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram30.R;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class FotosMiMascotaAdaptador  extends RecyclerView.Adapter<FotosMiMascotaAdaptador.MascotaFotoViewHolder> {

    ArrayList<Mascota> arrayListFotoMascotas;
    Activity activity;
    

    public FotosMiMascotaAdaptador(ArrayList<Mascota> arrayListMascotas, Activity activity){
        this.arrayListFotoMascotas = arrayListMascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fotos_mi_mascota_cardview, parent, false);
        return new MascotaFotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaFotoViewHolder holder, int position) {
        final Mascota mascota = arrayListFotoMascotas.get(position);
        holder.imgFotoMiMascota.setImageResource(mascota.getFoto());
        holder.tvLikesCVFotoMiMascota.setText(String.format("%d", mascota.getLikes()));
        
        };


    @Override
    public int getItemCount() {

        return arrayListFotoMascotas.size();
    }

    public static class MascotaFotoViewHolder extends RecyclerView.ViewHolder{
        ImageView imgFotoMiMascota;
        TextView tvLikesCVFotoMiMascota;

        public MascotaFotoViewHolder(View itemView) {
            super(itemView);
            imgFotoMiMascota      = (ImageView) itemView.findViewById(R.id.imgFotoMimascota);
            tvLikesCVFotoMiMascota = (TextView) itemView.findViewById(R.id.tvLikesCVFotoMiMascota);
        }
    }

}

