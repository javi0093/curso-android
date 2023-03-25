package com.example.petagram30;

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

import java.text.BreakIterator;
import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> arrayListMascotas;
    Activity activity;

    public Mascota[] ultimoscinco = new Mascota[5];

    public Mascota[] getUltimoscinco() {
        return ultimoscinco;
    }

    public MascotaAdaptador(ArrayList<Mascota> arrayListMascotas, Activity activity){
        this.arrayListMascotas = arrayListMascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = arrayListMascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvLikesCV.setText(String.format("%d", mascota.getLikes()));
        holder.imgbtnLikeBlancoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Le diste Me gusta a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                int nlikes = mascota.getLikes();
                mascota.setLikes(nlikes +1);
                holder.tvLikesCV.setText(String.format("%d", mascota.getLikes()));
                Mascota temp;
                for (int i = 3; i > -1; i--) {
                    temp = ultimoscinco[i];
                    ultimoscinco[i+1]=temp;
                }
                ultimoscinco[0] = mascota;


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListMascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private static ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private static ImageButton imgbtnLikeBlancoCV;
        //private static ImageButton imgbtnTopCinco;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
            imgbtnLikeBlancoCV = (ImageButton) itemView.findViewById(R.id.imgbtnLikeBlancoCV);
            //imgbtnTopCinco = (ImageButton) itemView.findViewById(R.id.imgbtnTopCinco);
        }
    }
}
