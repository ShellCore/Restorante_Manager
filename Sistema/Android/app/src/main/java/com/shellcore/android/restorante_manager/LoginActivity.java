package com.shellcore.android.restorante_manager;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.shellcore.android.restorante_manager.util.FormValue;
import com.shellcore.android.restorante_manager.util.Logs;

public class LoginActivity extends AppCompatActivity {

    // Components
    private RelativeLayout relLogin;
    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getComponents();
        setClickListeners();
    }

    private void getComponents() {
        try {
            relLogin = (RelativeLayout) findViewById(R.id.rel_login);
            tilUser = (TextInputLayout) findViewById(R.id.til_login_user);
            tilPassword = (TextInputLayout) findViewById(R.id.til_login_password);
            btnLogin = (Button) findViewById(R.id.btn_login);
        } catch (Exception e) {
            Logs.errorGetComponents(e);
        }
    }

    private void setClickListeners() {
        btnLogin.setOnClickListener(new OnLoginClickListener());
    }

    private class OnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (validData()) {
                // TODO Server Login
                Snackbar.make(relLogin, "Login correcto", Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public boolean validData() {
        boolean valido = true;
        String user = FormValue.getText(tilUser);
        String password = FormValue.getText(tilPassword);
        if (user.isEmpty()) {
            valido = false;
            tilUser.setError("Debe escribir un usuario");
        } else {
            tilUser.setError(null);
        }
        if (password.isEmpty()) {
            valido = false;
            tilPassword.setError("Debe escribir una contraseña");
        } else {
            tilPassword.setError(null);
        }
        return valido;
    }
}
