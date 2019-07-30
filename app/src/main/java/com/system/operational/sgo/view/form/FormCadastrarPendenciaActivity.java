package com.system.operational.sgo.view.form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.system.operational.sgo.DAO.DatabaseInsertPendency;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.Pendency;
import com.system.operational.sgo.view.main.MainActivity;

public class FormCadastrarPendenciaActivity extends AppCompatActivity {

    TextView nameOne;
    TextView nameTwo;
    EditText formPendencia;
    EditText formRecuperar;
    EditText formLayer;
    TextView btnUpdate;
    Pendency pendency = new Pendency();
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pendencia);

        castLayout();
        buttun();

        context = this;
        nameOne.setText(Controller.ESTACAO.get(1).toString());
        nameTwo.setText(Controller.ESTACAO.get(2).toString());
    }

    private void castLayout() {
        nameOne = findViewById(R.id.formPendencyStationNameStationOneId);
        nameTwo = findViewById(R.id.formPendencyStationNameStationTwoId);
        formPendencia = findViewById(R.id.formPendencyInfoPendencyId);
        formRecuperar = findViewById(R.id.formPendencyRecoverId);
        formLayer = findViewById(R.id.formPendencyLayerId);
        btnUpdate = findViewById(R.id.formPendencyBtnRegisterId);
    }

    private void buttun() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) DatabaseInsertPendency.inserirPendencia(pendency);
            }
        });
    }

    private boolean validateForm() {
        if (formPendencia.getText().toString().isEmpty()) {
            formPendencia.setError("Campo obrigatório");
            return false;
        } else if (formRecuperar.getText().toString().isEmpty()) {
            formRecuperar.setError("Campo obrigatório");
            return false;
        } else if (formLayer.getText().toString().isEmpty()) {
            formLayer.setError("Campo obrigatório");
            return false;
        } else {
            pendency.setIdUsuario(Controller.User.id_usuario);
            pendency.setIdEstacao((Integer) Controller.ESTACAO.get(0));
            pendency.setPendencia(formPendencia.getText().toString());
            pendency.setRecuperar(formRecuperar.getText().toString());
            pendency.setLayer(formLayer.getText().toString());
            pendency.setUsuarioMod(Controller.User.getNome());
            return true;
        }
    }

    public static void activity(Context contexto) {
        Intent intent = new Intent(contexto, MainActivity.class);
        contexto.startActivity(intent);
    }
}
