package com.system.operational.sgo.view.form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.system.operational.sgo.DAO.DatabaseInsertDataStation;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.UpdateStation;
import com.system.operational.sgo.view.main.MainActivity;

public class FormInserirDadosEstacaoActivity extends AppCompatActivity {

    TextView nameOne;
    TextView nameTwo;
    EditText formTipoAcesso;
    RadioButton formBateriasRbSim;
    RadioButton formBateriasRbNao;
    EditText formQtdBanco;
    EditText formFabricanteFonte;
    EditText formQtdUr;
    RadioButton formFolhaFonteSim;
    RadioButton formFolhaFonteNao;
    EditText formMedidor;
    RadioButton formConcentradorSim;
    RadioButton formConcentradorNao;
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
        formBateriasRbSim = findViewById(R.id.formRbSimInsertStationBateriasId);
        formBateriasRbNao = findViewById(R.id.formRbNaoInsertStationBateriasId);
        formQtdBanco = findViewById(R.id.formInsertStationQtdBancosId);
        formFabricanteFonte = findViewById(R.id.formInsertStationFabricanteDaFonteId);
        formQtdUr = findViewById(R.id.formInsertStationQtdUrId);
        formFolhaFonteSim = findViewById(R.id.formRbSimInsertStationFontePorForaId);
        formFolhaFonteNao = findViewById(R.id.formRbNaoInsertStationFontePorForaId);
        formMedidor = findViewById(R.id.formInsertStationNumMedidorId);
        formConcentradorSim = findViewById(R.id.formRbSimInsertStationConcentradorId);
        formConcentradorNao = findViewById(R.id.formRbNaoInsertStationConcentradorId);

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
        } else if (!formBateriasRbSim.isChecked() && !formBateriasRbNao.isChecked()) {
            Toast.makeText(FormInserirDadosEstacaoActivity.this, "Informe se possui bateria ou não!", Toast.LENGTH_SHORT).show();
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
        } else  if (!formFolhaFonteSim.isChecked() && !formFolhaFonteNao.isChecked()) {
            Toast.makeText(FormInserirDadosEstacaoActivity.this, "Informe se a fonte é por fora ou não!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (formMedidor.getText().toString().isEmpty()) {
            formMedidor.setError("Campo obrigatório");
            return false;
        } else if (!formConcentradorSim.isChecked() && !formConcentradorNao.isChecked()) {
            Toast.makeText(FormInserirDadosEstacaoActivity.this, "Informe se existe o concentrador!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            insertStation.setIdUsuario(Controller.User.id_usuario);
            insertStation.setIdEstacao((Integer) Controller.ESTACAO.get(0));
            insertStation.setTipoDeAcesso(formTipoAcesso.getText().toString());
            if(formBateriasRbSim.isChecked()) insertStation.setBateria("Sim");
            if(formBateriasRbNao.isChecked()) insertStation.setBateria("Não");
            insertStation.setQtdBanco(formQtdBanco.getText().toString());
            insertStation.setFabricanteFonte(formFabricanteFonte.getText().toString());
            insertStation.setQtdUr(formQtdUr.getText().toString());
            if(formFolhaFonteSim.isChecked()) insertStation.setFolhaFonte("Sim");
            if(formFolhaFonteNao.isChecked()) insertStation.setFolhaFonte("Não");
            insertStation.setMedidor(formMedidor.getText().toString());
            if(formConcentradorSim.isChecked()) insertStation.setConcentrador("Sim");
            if(formConcentradorNao.isChecked()) insertStation.setConcentrador("Não");
            return true;
        }
    }

    public static void activity(Context contexto) {
        Intent intent = new Intent(contexto, MainActivity.class);
        contexto.startActivity(intent);
    }
}