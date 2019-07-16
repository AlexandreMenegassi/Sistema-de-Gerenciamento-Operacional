package com.system.operational.sgo.view.form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.system.operational.sgo.DAO.DatabaseUpdateStation;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.UpdateStation;
import com.system.operational.sgo.view.main.MainActivity;

public class FormAtualizarDadosEstacaoActivity extends AppCompatActivity {

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
    UpdateStation updateStation = new UpdateStation();
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_atualizar);

        castLayout();
        buttun();

        context = this;
        nameOne.setText(Controller.ESTACAO.get(1).toString());
        nameTwo.setText(Controller.ESTACAO.get(2).toString());
    }

    private void castLayout() {
        nameOne = findViewById(R.id.formUpdateStationNameStationOneId);
        nameTwo = findViewById(R.id.formUpdateStationNameStationTwoId);
        formTipoAcesso = findViewById(R.id.formUpdateStationTipoAcessoId);
        formBaterias = findViewById(R.id.formUpdateStationBateriasId);
        formQtdBanco = findViewById(R.id.formUpdateStationQtdBancosId);
        formFabricanteFonte = findViewById(R.id.formUpdateStationFabricanteDaFonteId);
        formQtdUr = findViewById(R.id.formUpdateStationQtdUrId);
        formFolhaFonte = findViewById(R.id.formUpdateStationFontePorForaId);
        formMedidor = findViewById(R.id.formUpdateStationNumMedidorId);
        formConcentrador = findViewById(R.id.formUpdateStationConcentradorId);
        btnUpdate = findViewById(R.id.formUpdateStationBtnUpdateId);
    }

    private void buttun() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) DatabaseUpdateStation.atualizarEstacao(updateStation);
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
            updateStation.setIdUsuario(Controller.User.id_usuario);
            updateStation.setIdEstacao((Integer) Controller.ESTACAO.get(0));
            updateStation.setTipoDeAcesso(formTipoAcesso.getText().toString());
            updateStation.setBateria(formBaterias.getText().toString());
            updateStation.setQtdBanco(formQtdBanco.getText().toString());
            updateStation.setFabricanteFonte(formFabricanteFonte.getText().toString());
            updateStation.setQtdUr(formQtdUr.getText().toString());
            updateStation.setFolhaFonte(formFolhaFonte.getText().toString());
            updateStation.setMedidor(formMedidor.getText().toString());
            updateStation.setConcentrador(formConcentrador.getText().toString());
            return true;
        }
    }

    public static void activity(Context contexto) {
        Intent intent = new Intent(contexto, MainActivity.class);
        contexto.startActivity(intent);
    }
}
