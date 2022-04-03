package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    private EditText formUsername, formPassword;
    private Button tombolmasuk, tombolregis;
    private String username, password;
    private final String MY_PREFS_NAME = "LOGIN_CACHE";
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        initView();
    }
    private void initView(){
        formUsername = (EditText) findViewById(R.id.username);
        formPassword = (EditText) findViewById(R.id.password);
        tombolmasuk = (Button) findViewById(R.id.tombolmasuk);
        tombolregis = (Button) findViewById(R.id.tombolregis);

        sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if(!username.equals("")){
            formUsername.setText(username);
        }
        if(!password.equals("")){
            formPassword.setText(password);
        }

        tombolmasuk.setOnClickListener(this);
        tombolregis.setOnClickListener(this);
    }
    @Override
    public void onClick(View notif){
        username = formUsername.getText().toString();
        password = formPassword.getText().toString();

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        if(notif.getId()==R.id.tombolmasuk){
            if(username.equals("")){
                Toast.makeText(getApplicationContext(),"Username tidak boleh kosong", Toast.LENGTH_SHORT).show();

            }else if(password.equals("")){
                Toast.makeText(getApplicationContext(),"Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{Toast.makeText(getApplicationContext(),"berhasil",Toast.LENGTH_SHORT).show();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtra("username",username);
                startActivity(i);
            }
        }else if(notif.getId()== R.id.tombolregis){
            Intent i = new Intent(Login.this, RegistrationAct.class);
            startActivity(i);
        }

    }


}
