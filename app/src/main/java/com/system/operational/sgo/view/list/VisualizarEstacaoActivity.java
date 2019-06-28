package com.system.operational.sgo.view.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.view.data.DadosEstacao;
import com.system.operational.sgo.view.forms.FormularioAtualizarEstacaoActivity;

public class VisualizarEstacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_estacao);

        context = this;
        recyclerView = findViewById(R.id.recyclerViewVisualizarEstacaoId);
        Controller.listaDeEstacao(this, recyclerView, 1);
    }

    public static void activityForm(Context contexto) {
        Intent intent = new Intent(contexto, FormularioAtualizarEstacaoActivity.class);
        contexto.startActivity(intent);
    }

    public static void activityInfo(Context contexto) {
        Intent intent = new Intent(contexto, DadosEstacao.class);
        contexto.startActivity(intent);
    }
}
