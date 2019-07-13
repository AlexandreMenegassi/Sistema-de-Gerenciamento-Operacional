package com.system.operational.sgo.view.form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.system.operational.sgo.DAO.DatabaseInsertDataStation;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.UpdateStation;
import com.system.operational.sgo.view.main.MainActivity;

public class FormularioInserirDadosEstacaoActivity extends AppCompatActivity {

    TextView nameOne;
    TextView nameTwo;
    EditText formTipoAcesso;
    EditText formBaterias;
    EditText formQtdBanco;
    EditText formFabricanteFonte;
    EditText formQtdUr;
    EditText formFolhaFonte;
    EditText formMedidor;
    EditText formConcentrador;
    TextView btnUpdate;
    UpdateStation insertStation = new UpdateStation();
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_inserir);

        castLayout();
        buttun();

        context = this;
        nameOne.setText(Controller.ESTACAO.get(1).toString());
        nameTwo.setText(Controller.ESTACAO.get(2).toString());
    }

    private void castLayout() {
        nameOne = findViewById(R.id.formInsertStationNameStationOneId);
        nameTwo = findViewById(R.id.formInsertStationNameStationTwoId);
        formTipoAcesso = findViewById(R.id.formInsertStationTipoAcessoId);
        formBaterias = findViewById(R.id.formInsertStationBateriasId);
        formQtdBanco = findViewById(R.id.formInsertStationQtdBancosId);
        formFabricanteFonte = findViewById(R.id.formInsertStationFabricanteDaFonteId);
        formQtdUr = findViewById(R.id.formInsertStationQtdUrId);
        formFolhaFonte = findViewById(R.id.formInsertStationFontePorForaId);
        formMedidor = findViewById(R.id.formInsertStationNumMedidorId);
        formConcentrador = findViewById(R.id.formInsertStationConcentradorId);
        btnUpdate = findViewById(R.id.formInsertStationBtnUpdateId);
    }

    private void buttun() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) DatabaseInsertDataStation.inserirDadosEstacao(insertStation);
            }
        });
    }

    private boolean validateForm() {
        if (formTipoAcesso.getText().toString().isEmpty()) {
            formTipoAcesso.setError("Campo obrigatório");
            return false;
        } else if (formBaterias.getText().toString().isEmpty()) {
            formBaterias.setError("Campo obrigatório");
            return false;
        } else if (formQtdBanco.getText().toString().isEmpty()) {
            formQtdBanco.setError("Campo obrigatório");
            return false;
        } else if (formFabricanteFonte.getText().toString().isEmpty()) {
            formFabricanteFonte.setError("Campo obrigatório");
            return false;
        } else if (formQtdUr.getText().toString().isEmpty()) {
            formQtdUr.setError("Campo obrigatório");
            return false;
        } else if (formFolhaFonte.getText().toString().isEmpty()) {
            formFolhaFonte.setError("Campo obrigatório");
            return false;
        } else if (formMedidor.getText().toString().isEmpty()) {
            formMedidor.setError("Campo obrigatório");
            return false;
        } else if (formConcentrador.getText().toString().isEmpty()) {
            formConcentrador.setError("Campo obrigatório");
            return false;
        } else {
            insertStation.setIdUsuario(Controller.USUARIO.id_usuario);
            insertStation.setIdEstacao((Integer) Controller.ESTACAO.get(0));
            insertStation.setTipoDeAcesso(formTipoAcesso.getText().toString());
            insertStation.setBateria(formBaterias.getText().toString());
            insertStation.setQtdBanco(formQtdBanco.getText().toString());
            insertStation.setFabricanteFonte(formFabricanteFonte.getText().toString());
            insertStation.setQtdUr(formQtdUr.getText().toString());
            insertStation.setFolhaFonte(formFolhaFonte.getText().toString());
            insertStation.setMedidor(formMedidor.getText().toString());
            insertStation.setConcentrador(formConcentrador.getText().toString());
            return true;
        }
    }

    public static void activity(Context contexto) {
        Intent intent = new Intent(contexto, MainActivity.class);
        contexto.startActivity(intent);
    }
}