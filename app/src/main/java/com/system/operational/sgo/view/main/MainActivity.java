package com.system.operational.sgo.view.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.system.operational.sgo.DAO.DatabaseList;
import com.system.operational.sgo.R;
import com.system.operational.sgo.view.list.AtualizarEstacaoActivity;
import com.system.operational.sgo.view.list.CadastrarPendenciasActivity;
import com.system.operational.sgo.view.list.VisualizarEstacaoActivity;

public class MainActivity extends AppCompatActivity {

    Button atualizarEstacao;
    Button cadastrarPendencias;
    Button vizualizarEstacao;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        castLayout();
        buttons();

        DatabaseList.lerEstacoes();

    }

    public void castLayout(){
        atualizarEstacao = findViewById(R.id.atualizarEstacaoId);
        cadastrarPendencias = findViewById(R.id.cadastrarPendenciasId);
        vizualizarEstacao = findViewById(R.id.vizualizarEstacaoId);
    }

    public void buttons(){
        atualizarEstacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AtualizarEstacaoActivity.class));
            }
        });

        cadastrarPendencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastrarPendenciasActivity.class));
            }
        });

        vizualizarEstacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VisualizarEstacaoActivity.class));
            }
        });
    }
}
