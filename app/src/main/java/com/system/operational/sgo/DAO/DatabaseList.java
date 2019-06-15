package com.system.operational.sgo.DAO;

import android.os.AsyncTask;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.Estacao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseList {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    public static void lerEstacoes() {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_LISTAR_ESTACAO, null, CODE_POST_REQUEST);
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
                    listarEstacoes(object.getJSONArray("lista"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST) return requestHandler.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST) return requestHandler.sendGetRequest(url);

            return null;
        }
    }

    public static void listarEstacoes(@org.jetbrains.annotations.NotNull JSONArray station) throws JSONException {

        Controller.listAtualizarEstacao.clear();

        for (int i = 0; i < station.length(); i++) {
            JSONObject obj = station.getJSONObject(i);
            Controller.listAtualizarEstacao.add(new Estacao(
                obj.getInt("idestacao"),
                obj.getString("endid"),
                obj.getString("nomeestacao"),
                obj.getString("regional"),
                obj.getString("uf"),
                obj.getString("cidade")));
        }
    }
}