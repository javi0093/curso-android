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
import com.example.petagram30.db.ConstructorMascotas;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> arrayListMascotas;
    Activity activity;

    int[] arrayFavoritas = new int[100];
    int i = 0;
    boolean sw = false;
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
        holder.tvLikesCV.setText(String.format("%d", mascota.getLikes()) + " " + activity.getString(R.string.plikes));
        holder.imgbtnLikeBlancoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Le diste Me gusta a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvLikesCV.setText(constructorMascotas.obtenerLikesMascota(mascota)+ " " + activity.getString(R.string.plikes));


                for (int x = 0; x < arrayFavoritas.length; x++) {
                    if (arrayFavoritas[x] == mascota.getId()) {
                        sw = true;
                    }
                }


                if(arrayFavoritas.length <= 100 && sw == false){
                    arrayFavoritas[i] = mascota.getId();
                    i++;
                    constructorMascotas.insertarUltimosCinco(mascota);
                }else if(sw == false){
                    arrayFavoritas[i] = mascota.getId();
                    constructorMascotas.insertarUltimosCinco(mascota);
                }
                sw = false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListMascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton imgbtnLikeBlancoCV;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
            imgbtnLikeBlancoCV = (ImageButton) itemView.findViewById(R.id.imgbtnLikeBlancoCV);

        }
    }


}
