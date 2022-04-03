package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView labelUsername;
    Button btnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelUsername = findViewById(R.id.testt);
        btnIntent = findViewById(R.id.Intens);
        if(getIntent().getExtras() !=null){
            Bundle bun = getIntent().getExtras();
            labelUsername.setText("Selamat datang "+bun.getString("username"));
        }
        btnIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()== R.id.Intens){
            Intent intentimplicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kode.id/"));
            startActivity(intentimplicit);
        }
    }
}