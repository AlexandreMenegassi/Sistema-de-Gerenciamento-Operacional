package com.system.operational.sgo.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.system.operational.sgo.DAO.DatabaseAuth;
import com.system.operational.sgo.R;
import com.system.operational.sgo.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;
    private TextView btnLogin;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        castLayout();
        buttonLogin();
    }

    public void castLayout() {
        editTextEmail = findViewById(R.id.form_login_login_Id);
        editTextSenha = findViewById(R.id.form_login_senha_Id);
        btnLogin = findViewById(R.id.btn_login_Id);
    }

    public void buttonLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) DatabaseAuth.verificarUsuario(editTextEmail.getText().toString(), editTextSenha.getText().toString());
            }
        });
    }

    private boolean validateForm() {
        boolean formularioPreenchido = true;
        if (editTextEmail.getText().toString().isEmpty()) {
            formularioPreenchido = false;
            Toast.makeText(this, "Informe seu Login!", Toast.LENGTH_SHORT).show();
        }else if (editTextSenha.getText().toString().isEmpty()) {
            formularioPreenchido = false;
            Toast.makeText(this, "Informe sua Senha!", Toast.LENGTH_SHORT).show();
        }
        return formularioPreenchido;
    }

    public static void activity(Context contexto) {
        Intent login = new Intent(contexto, MainActivity.class);
        contexto.startActivity(login);
    }
}
