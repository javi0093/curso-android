package com.example.petagram30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.petagram30.adapter.MascotaAdaptador;
import com.example.petagram30.pojo.Mascota;

import java.util.ArrayList;

public class top5 extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> arrayListMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Bundle parametros   = getIntent().getExtras();
        String likes1 = parametros.getString(getResources().getString(R.string.plikes));*/



        listaMascotas = (RecyclerView) findViewById(R.id.rv5Mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();



    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(arrayListMascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        arrayListMascotas = new ArrayList<Mascota>();
        arrayListMascotas.add(new Mascota("pepa", R.drawable.perro1, 5));
        arrayListMascotas.add(new Mascota("juana isabel", R.drawable.perro2, 4));
        arrayListMascotas.add(new Mascota("carlos fernando", R.drawable.perro3, 3));
        arrayListMascotas.add(new Mascota("luis enrrique", R.drawable.perro4, 2));
        arrayListMascotas.add(new Mascota("marco aurelio", R.drawable.perro5, 1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent intent2 = new Intent(this, ActivityContacto.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}