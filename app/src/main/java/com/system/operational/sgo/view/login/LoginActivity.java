package com.system.operational.sgo.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.system.operational.sgo.DAO.DatabaseAuth;
import com.system.operational.sgo.R;
import com.system.operational.sgo.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private AppCompatEditText editTextEmail;
    private TextInputLayout textInputLayoutEmail;
    private AppCompatEditText editTextSenha;
    private TextInputLayout textInputLayoutSenha;
    private Button btnLogin;
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
        textInputLayoutEmail = findViewById(R.id.txt_layout_login_Id);
        editTextSenha = findViewById(R.id.form_login_senha_Id);
        textInputLayoutSenha = findViewById(R.id.txt_layout_senha_Id);
        btnLogin = findViewById(R.id.btn_login_Id);
    }

    public void buttonLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    DatabaseAuth.verificarUsuario(editTextEmail.getText().toString(), editTextSenha.getText().toString());
                }
            }
        });
    }

    private boolean validateForm() {
        boolean formularioPreenchido = true;
        if (editTextEmail.getText().toString().isEmpty()) {
            textInputLayoutEmail.setErrorEnabled(true);
            textInputLayoutEmail.setError("Informe seu email.");
            formularioPreenchido = false;
        } else {
            textInputLayoutEmail.setErrorEnabled(false);
        }
        if (editTextSenha.getText().toString().isEmpty()) {
            textInputLayoutSenha.setErrorEnabled(true);
            textInputLayoutSenha.setError("Informe sua senha.");
            formularioPreenchido = false;
        } else {
            textInputLayoutSenha.setErrorEnabled(false);
        }
        return formularioPreenchido;
    }

    public static void activity(Context contexto) {
        Intent login = new Intent(contexto, MainActivity.class);
        contexto.startActivity(login);
    }
}
