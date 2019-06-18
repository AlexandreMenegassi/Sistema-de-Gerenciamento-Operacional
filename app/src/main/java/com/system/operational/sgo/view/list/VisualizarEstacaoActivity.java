package com.system.operational.sgo.view.list;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;

public class VisualizarEstacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_estacao);

        context = this;
        recyclerView = findViewById(R.id.recyclerViewVisualizarEstacaoId);
        Controller.listaDeEstacao(this, recyclerView, 2);
    }
}
