package com.system.operational.sgo.view.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;

public class DadosEstacao extends AppCompatActivity {

    TextView nameOne;
    TextView nameTwo;
    TextView dateTipoAcesso;
    TextView dateBaterias;
    TextView dateQtdBanco;
    TextView dateFabricanteFonte;
    TextView dateQtdUr;
    TextView dateFolhaFonte;
    TextView dateMedidor;
    TextView dateConcentrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_estacao);

        castLayout();
        dateStation();
    }

    private void castLayout() {
        nameOne = findViewById(R.id.dateStationNameOneId);
        nameTwo = findViewById(R.id.dateStationNameTwoId);
        dateTipoAcesso = findViewById(R.id.dateStationTipoAcessoId);
        dateBaterias = findViewById(R.id.dateStationBateriasId);
        dateQtdBanco = findViewById(R.id.dateStationQtdBancoId);
        dateFabricanteFonte = findViewById(R.id.dateStationFabricanteId);
        dateQtdUr = findViewById(R.id.dateStationQtdUrId);
        dateFolhaFonte = findViewById(R.id.dateStationFolhaFonteId);
        dateMedidor = findViewById(R.id.dateStationMedidorId);
        dateConcentrador = findViewById(R.id.dateStationConcentradorId);
    }

    private void dateStation() {
        nameOne.setText(Controller.ESTACAO.get(1).toString());
        nameTwo.setText(Controller.ESTACAO.get(2).toString());
        dateTipoAcesso.setText(Controller.dadosDaEstacao.getTipoDeAcesso());
        dateBaterias.setText(Controller.dadosDaEstacao.getBateria());
        dateQtdBanco.setText(String.valueOf(Controller.dadosDaEstacao.getQtdBanco()));
        dateFabricanteFonte.setText(Controller.dadosDaEstacao.getFabriicanteFonte());
        dateQtdUr.setText(String.valueOf(Controller.dadosDaEstacao.getQtdUr()));
        dateFolhaFonte.setText(Controller.dadosDaEstacao.getFolhaFonte());
        dateMedidor.setText(Controller.dadosDaEstacao.getMedidor());
        dateConcentrador.setText(Controller.dadosDaEstacao.getConcentrador());
    }
}
