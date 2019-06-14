package com.system.operational.sgo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.DAO.Database;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;

public class AtualizarEstacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_estacao);

        recyclerView = findViewById(R.id.recyclerViewAtualizarEstacaoId);
        Controller.listarCliente(this, recyclerView);
    }
}
