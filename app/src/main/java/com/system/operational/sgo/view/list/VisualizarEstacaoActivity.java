package com.system.operational.sgo.view.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.view.data.DadosEstacao;
import com.system.operational.sgo.view.form.FormInserirDadosEstacaoActivity;

public class VisualizarEstacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static Context context;
    private TextView procurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dados);

        context = this;
        recyclerView = findViewById(R.id.recyclerViewVisualizarEstacaoId);
        procurar = findViewById(R.id.procurarDadosEstacaoId);
        Controller.listaDeEstacao(this, recyclerView, 1);

        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteDadosTextViewId);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Controller.LISTANOMEESTACAO);
        autoCompleteTextView.setAdapter(arrayAdapter);

        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.filtrarEstacao(VisualizarEstacaoActivity.this, recyclerView, autoCompleteTextView.getText().toString(), 1);
            }
        });
    }

    public static void activityForm(Context contexto) {
        Intent intent = new Intent(contexto, FormInserirDadosEstacaoActivity.class);
        contexto.startActivity(intent);
    }

    public static void activityInfo(Context contexto) {
        Intent intent = new Intent(contexto, DadosEstacao.class);
        contexto.startActivity(intent);
    }
}
