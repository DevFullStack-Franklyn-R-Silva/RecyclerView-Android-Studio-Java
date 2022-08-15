package com.hadesfranklyn.recyclerview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hadesfranklyn.recyclerview.R;
import com.hadesfranklyn.recyclerview.adapter.Adapter;
import com.hadesfranklyn.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter();

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes() {
        Filme filme = new Filme("O Predador: A Caçada", "Ficção científica/Ação", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Agente Oculto", "Ação/Suspense", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Tudo em Todo o Lugar ao Mesmo Tempo", "Aventura/Ficção científica", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Cidade Perdida", "Romance/Aventura", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Lightyear", "Aventura/Infantil", "2022");
        this.listaFilmes.add(filme);
    }
}