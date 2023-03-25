package com.example.petagram30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView listaMascotas;
    private static ImageButton imgbtnTopCinco;

    private Mascota[] top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        imgbtnTopCinco = (ImageButton) findViewById(R.id.imgbtnTopCinco);

        imgbtnTopCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "prueba", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, top5.class);
                intent.putExtra(getResources().getString(R.string.plikes1),arrayListMascotas.get(0).getLikes());
                intent.putExtra(getResources().getString(R.string.plikes2),arrayListMascotas.get(1).getLikes());
                intent.putExtra(getResources().getString(R.string.plikes3),arrayListMascotas.get(2).getLikes());
                intent.putExtra(getResources().getString(R.string.plikes4),arrayListMascotas.get(3).getLikes());
                intent.putExtra(getResources().getString(R.string.plikes5),arrayListMascotas.get(4).getLikes());

                startActivity(intent);
            }
        });
    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(arrayListMascotas, this);
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