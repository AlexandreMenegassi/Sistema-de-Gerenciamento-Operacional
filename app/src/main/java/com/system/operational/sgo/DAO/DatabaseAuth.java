package com.system.operational.sgo.DAO;

import android.os.AsyncTask;
import android.widget.Toast;

import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.view.login.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DatabaseAuth {

    public static void verificarUsuario(String nome, String senha) {
        PerformNetworkRequest request = new PerformNetworkRequest(URL.URL_VERIFICAR_USUARIO + nome + "&senha=" + senha, null, URL.CODE_GET_REQUEST);
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
                    Toast.makeText(LoginActivity.context, Controller.message, Toast.LENGTH_SHORT).show();
                    LoginActivity.activity(LoginActivity.context);
                } else {
                    Controller.message = object.getString("message");
                    Toast.makeText(LoginActivity.context, Controller.message, Toast.LENGTH_SHORT).show();
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

    public static void autenticarUsuario(@org.jetbrains.annotations.NotNull JSONArray station) throws JSONException {
        Controller.USUARIO.setId_usuario(station.getJSONObject(0).getInt("idusuario"));
        Controller.USUARIO.setNome(station.getJSONObject(0).getString("nome"));
        Controller.USUARIO.setNivel(station.getJSONObject(0).getInt("nivel"));
    }
}