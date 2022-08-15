package com.hadesfranklyn.recyclerview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hadesfranklyn.recyclerview.R;
import com.hadesfranklyn.recyclerview.RecyclerItemClickListener;
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
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "Item pressionado " + filme.getTituloFilme(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "Click longo " + filme.getTituloFilme(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
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

        filme = new Filme("O Homem do Norte", "Aventura/Ação", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Morbius", "Ação/Fantasia", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Ted Bundy: A Confissão Final", "Crime/Drama", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Encanto", "Musical/Infantil", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Eternos", "Ação/Fantasia", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem-Aranha: Sem Volta para Casa", "Ação/Aventura", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Milagre na Cela 7", "Drama ", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("1917", "Guerra/Drama", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("A Fera do Mar", "Aventura/Comédia", "2022");
        this.listaFilmes.add(filme);
    }
}