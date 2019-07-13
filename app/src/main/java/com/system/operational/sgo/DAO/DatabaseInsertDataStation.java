package com.system.operational.sgo.DAO;

import android.os.AsyncTask;
import android.widget.Toast;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.UpdateStation;
import com.system.operational.sgo.view.form.FormularioInserirDadosEstacaoActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseInsertDataStation {

    public static void inserirDadosEstacao(UpdateStation estacao) {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_ADICIONAR_DADOS_ESTACAO + parametroUrl(estacao), null, URL.CODE_GET_REQUEST);
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
                    Controller.message = object.getString("message");
                    Toast.makeText(FormularioInserirDadosEstacaoActivity.context, Controller.message, Toast.LENGTH_LONG).show();
                    FormularioInserirDadosEstacaoActivity.activity(FormularioInserirDadosEstacaoActivity.context);
                } else {
                    Controller.message = object.getString("message");
                    Toast.makeText(FormularioInserirDadosEstacaoActivity.context, Controller.message, Toast.LENGTH_LONG).show();
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

    private static String parametroUrl(UpdateStation station){
        String parametro = station.getTipoDeAcesso();
        parametro += "&bateria=" + station.getBateria();
        parametro += "&qtdBanco=" + station.getQtdBanco();
        parametro += "&fabricante=" + station.getFabriicanteFonte();
        parametro += "&qtdUr=" + station.getQtdUr();
        parametro += "&folha=" + station.getFolhaFonte();
        parametro += "&medidor=" + station.getMedidor();
        parametro += "&concentrador=" + station.getConcentrador();
        parametro += "&idStation=" + station.getIdEstacao();
        parametro += "&idUser=" + station.getIdUsuario();
        return parametro;
    }
}