package com.example.petagram30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView listaMascotas;


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
            case R.id.msettings:
                Intent intent2 = new Intent(this, ActivitySettings.class);
                startActivity(intent2);
                break;
            case R.id.mUltimos5:

                Intent intent3 = new Intent(MainActivity.this, top5.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




}