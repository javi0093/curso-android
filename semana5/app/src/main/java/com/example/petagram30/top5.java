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
import com.example.petagram30.adapter.UltimosCincoAdaptador;
import com.example.petagram30.db.ConstructorMascotas;
import com.example.petagram30.pojo.Mascota;
import com.example.petagram30.presentador.RecyclerViewUltimosCincoPresenter;

import java.util.ArrayList;

public class top5 extends AppCompatActivity implements IRecyclerViewFavoritasView {

    private RecyclerView listaMascotas;
    private UltimosCincoAdaptador adaptador;
    private RecyclerViewUltimosCincoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rv5Mascotas);
        presenter = new RecyclerViewUltimosCincoPresenter(this, this);



    }

    public void generarLinaerLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }


    public UltimosCincoAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        UltimosCincoAdaptador adaptador = new UltimosCincoAdaptador(mascotas, this);
        return adaptador;
    }

    public void inicializarAdaptadorRV(UltimosCincoAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout2:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mContacto2:
                Intent intent2 = new Intent(this, ActivityContacto.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
