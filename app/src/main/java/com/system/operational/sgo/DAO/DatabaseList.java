package com.system.operational.sgo.DAO;

import android.os.AsyncTask;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.Estacao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseList {

    public static void lerEstacoes() {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_LISTAR_ESTACAO, null, URL.CODE_POST_REQUEST);
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
                    listarEstacoes(object.getJSONArray("lista"));
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

    public static void listarEstacoes(@org.jetbrains.annotations.NotNull JSONArray station) throws JSONException {
        Controller.LISTADADOSESTACAO.clear();
        Controller.LISTANOMEESTACAO.clear();
        for (int i = 0; i < station.length(); i++) {
            Controller.LISTADADOSESTACAO.add(new Estacao(
                station.getJSONObject(i).getInt("idestacao"),
                station.getJSONObject(i).getString("endid"),
                station.getJSONObject(i).getString("nomeestacao"),
                station.getJSONObject(i).getString("regional"),
                station.getJSONObject(i).getString("uf"),
                station.getJSONObject(i).getString("cidade")));
            Controller.LISTANOMEESTACAO.add(station.getJSONObject(i).getString("nomeestacao"));
        }
    }
}