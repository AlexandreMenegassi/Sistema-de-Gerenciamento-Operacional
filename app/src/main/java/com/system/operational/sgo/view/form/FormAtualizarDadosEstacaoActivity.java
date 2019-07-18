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

import com.system.operational.sgo.DAO.DatabaseUpdateStation;
import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.UpdateStation;
import com.system.operational.sgo.view.main.MainActivity;

public class FormAtualizarDadosEstacaoActivity extends AppCompatActivity {

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
        formBateriasRbSim = findViewById(R.id.formRDSimUpdateStationBateriasId);
        formBateriasRbNao = findViewById(R.id.formRDNaoUpdateStationBateriasId);
        formQtdBanco = findViewById(R.id.formUpdateStationQtdBancosId);
        formFabricanteFonte = findViewById(R.id.formUpdateStationFabricanteDaFonteId);
        formQtdUr = findViewById(R.id.formUpdateStationQtdUrId);
        formFolhaFonteSim = findViewById(R.id.formRDSimUpdateStationFontePorForaId);
        formFolhaFonteNao = findViewById(R.id.formRDNaoUpdateStationFontePorForaId);
        formMedidor = findViewById(R.id.formUpdateStationNumMedidorId);
        formConcentradorSim = findViewById(R.id.formRDSimUpdateStationSiteId);
        formConcentradorNao = findViewById(R.id.formRDNaoUpdateStationSiteId);
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
        } else if (!formBateriasRbSim.isChecked() && !formBateriasRbNao.isChecked()) {
            Toast.makeText(FormAtualizarDadosEstacaoActivity.this, "Informe se possui bateria ou não!", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(FormAtualizarDadosEstacaoActivity.this, "Informe se a fonte é por fora ou não!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (formMedidor.getText().toString().isEmpty()) {
            formMedidor.setError("Campo obrigatório");
            return false;
        } else if (!formConcentradorSim.isChecked() && !formConcentradorNao.isChecked()) {
            Toast.makeText(FormAtualizarDadosEstacaoActivity.this, "Informe se existe o concentrador!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            updateStation.setIdUsuario(Controller.User.id_usuario);
            updateStation.setIdEstacao((Integer) Controller.ESTACAO.get(0));
            updateStation.setTipoDeAcesso(formTipoAcesso.getText().toString());
            if(formBateriasRbSim.isChecked()) updateStation.setBateria("Sim");
            if(formBateriasRbNao.isChecked()) updateStation.setBateria("Não");
            updateStation.setQtdBanco(formQtdBanco.getText().toString());
            updateStation.setFabricanteFonte(formFabricanteFonte.getText().toString());
            updateStation.setQtdUr(formQtdUr.getText().toString());
            if(formFolhaFonteSim.isChecked()) updateStation.setFolhaFonte("Sim");
            if(formFolhaFonteNao.isChecked()) updateStation.setFolhaFonte("Não");
            updateStation.setMedidor(formMedidor.getText().toString());
            if(formConcentradorSim.isChecked()) updateStation.setConcentrador("Sim");
            if(formConcentradorNao.isChecked()) updateStation.setConcentrador("Não");
            return true;
        }
    }

    public static void activity(Context contexto) {
        Intent intent = new Intent(contexto, MainActivity.class);
        contexto.startActivity(intent);
    }
}
