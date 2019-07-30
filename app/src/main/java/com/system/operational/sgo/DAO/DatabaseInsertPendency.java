package com.system.operational.sgo.DAO;

import android.os.AsyncTask;
import android.widget.Toast;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.Pendency;
import com.system.operational.sgo.view.form.FormCadastrarPendenciaActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseInsertPendency {

    public static void inserirPendencia(Pendency estacao) {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_CADASTRAR_PENDENCIA + parametroUrl(estacao), null, URL.CODE_GET_REQUEST);
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
                    Toast.makeText(FormCadastrarPendenciaActivity.context, Controller.message, Toast.LENGTH_LONG).show();
                    FormCadastrarPendenciaActivity.activity(FormCadastrarPendenciaActivity.context);
                } else {
                    Controller.message = object.getString("message");
                    Toast.makeText(FormCadastrarPendenciaActivity.context, Controller.message, Toast.LENGTH_LONG).show();
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

    private static String parametroUrl(Pendency pendency){
        String parametro = pendency.getPendencia();
        parametro += "&recuperar=" + pendency.getRecuperar();
        parametro += "&layer=" + pendency.getLayer();
        parametro += "&usuarioMod=" + pendency.getUsuarioMod();
        parametro += "&idStation=" + pendency.getIdEstacao();
        parametro += "&idUser=" + pendency.getIdUsuario();
        return parametro;
    }
}