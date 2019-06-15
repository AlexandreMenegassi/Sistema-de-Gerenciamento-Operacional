package com.system.operational.sgo.DAO;

import android.os.AsyncTask;

import com.system.operational.sgo.controller.Controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseAuth {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    public static boolean USUARIO_AUTENTICADO = false;

    public static void verificarUsuario(String nome, String senha) {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_VERIFICAR_USUARIO + nome + "&senha=" + senha, null, CODE_GET_REQUEST);
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
                if (object.getBoolean("error")) {
                    Controller.message = object.getString("message");
                    autenticarUsuario(object.getJSONArray("dados"));
                } else {
                    Controller.message = object.getString("message");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();
            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);
            if (requestCode == CODE_GET_REQUEST) return requestHandler.sendGetRequest(url);
            return null;
        }
    }

    public static void autenticarUsuario(@org.jetbrains.annotations.NotNull JSONArray station) throws JSONException {
        JSONObject obj = station.getJSONObject(0);
        Controller.USUARIO.setId_usuario(obj.getInt("idusuario"));
        Controller.USUARIO.setNome(obj.getString("nome"));
        Controller.USUARIO.setNivel(obj.getInt("nivel"));
        if (!obj.getString("nome").isEmpty()) USUARIO_AUTENTICADO = true;
    }
}