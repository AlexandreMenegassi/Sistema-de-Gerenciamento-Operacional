package com.system.operational.sgo.DAO;

import android.os.AsyncTask;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.view.list.VisualizarEstacaoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseDataStation {

    public static void dadosEstacao(int id) {
        DatabaseDataStation.PerformNetworkRequest request = new DatabaseDataStation.PerformNetworkRequest(URL.URL_DADOS_ESTACAO + id, null, URL.CODE_POST_REQUEST);
        request.execute();
    }

    private static class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    dadosDaEstacao(object.getJSONArray("dados"));
                    VisualizarEstacaoActivity.activityInfo(VisualizarEstacaoActivity.context);
                } else {
                    Controller.alertDialogStationNotUpdate(Controller.ESTACAO.get(1).toString(),Controller.ESTACAO.get(2).toString());
                    dadosDaEstacao(object.getJSONArray("dados"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();
            if (requestCode == URL.CODE_POST_REQUEST) return requestHandler.sendPostRequest(url, params);
            if (requestCode == URL.CODE_GET_REQUEST) return requestHandler.sendGetRequest(url);
            return null;
        }
    }

    public static void dadosDaEstacao(@org.jetbrains.annotations.NotNull JSONArray station) throws JSONException {
        Controller.dadosDaEstacao.setIdEstacao(station.getJSONObject(0).getInt("idestacao"));
        Controller.dadosDaEstacao.setTipoDeAcesso(station.getJSONObject(0).getString("tipoDeAcesso"));
        Controller.dadosDaEstacao.setBateria(station.getJSONObject(0).getString("bateria"));
        Controller.dadosDaEstacao.setQtdBanco(station.getJSONObject(0).getInt("qtdBanco"));
        Controller.dadosDaEstacao.setFabriicanteFonte(station.getJSONObject(0).getString("fabricanteFonte"));
        Controller.dadosDaEstacao.setQtdUr(station.getJSONObject(0).getInt("qtdUr"));
        Controller.dadosDaEstacao.setFolhaFonte(station.getJSONObject(0).getString("folhaFonte"));
        Controller.dadosDaEstacao.setMedidor(station.getJSONObject(0).getString("medidor"));
        Controller.dadosDaEstacao.setConcentrador(station.getJSONObject(0).getString("concentrador"));
    }
}
