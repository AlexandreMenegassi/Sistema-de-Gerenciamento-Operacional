package com.system.operational.sgo.view.list;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;

public class CadastrarPendenciasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView procurar;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pendencia);

        context = this;
        recyclerView = findViewById(R.id.recyclerViewCadastrarPendenciasId);
        procurar = findViewById(R.id.procurarPendenciaDadosEstacaoId);
        Controller.listaDeEstacao(this, recyclerView, 2);

        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompletePendenciaTextViewId);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Controller.LISTANOMEESTACAO);
        autoCompleteTextView.setAdapter(arrayAdapter);

        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.filtrarEstacao(CadastrarPendenciasActivity.this, recyclerView, autoCompleteTextView.getText().toString(), 2);
            }
        });
    }
}
