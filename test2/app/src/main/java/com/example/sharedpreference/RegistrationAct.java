package com.example.sharedpreference;

import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationAct extends AppCompatActivity implements View.OnClickListener {
    private EditText formUser, formPass;
    private Button tombolmasuk, tombolregis;

    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);
        initView();
    }

    private void initView() {

    }

    @Override
    public void onClick(View notif) {
        username = formUser.getText().toString();
        password = formPass.getText().toString();

        if (notif.getId() == R.id.tombolmasuk) {
            if (username.equals("")) {
                Toast.makeText(getApplicationContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();

            } else if (password.equals("")) {
                Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            }
        }

    }


}