package com.example.jcees.apkprova;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button btnExit, btnLocacao, btnFaleConosco, btnNossaLocalizacao, btnMaisInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
        btnFaleConosco = (Button) findViewById(R.id.btnFaleConosco);
        btnFaleConosco.setOnClickListener(this);
        btnLocacao = (Button) findViewById(R.id.btnLocacao);
        btnLocacao.setOnClickListener(this);
        btnNossaLocalizacao = (Button) findViewById(R.id.btnNossaLocalizacao);
        btnNossaLocalizacao.setOnClickListener(this);
        btnMaisInformacoes = (Button) findViewById(R.id.btnMaisInformacoes);
        btnMaisInformacoes.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnExit:
                finish();
                break;

            case R.id.btnFaleConosco:
                Uri call = Uri.parse("tel:0800 1234 1234");
                startActivity(new Intent(Intent.ACTION_CALL, call));
                break;

            case R.id.btnNossaLocalizacao:
                Uri mapa = Uri.parse("geo:0,0?q=Av+Litorânea+1000");
                startActivity(new Intent(Intent.ACTION_VIEW, mapa));
                break;

            case R.id.btnMaisInformacoes:
                Uri site = Uri.parse("http://www.disknotebook.com.br");
                startActivity(new Intent(Intent.ACTION_VIEW, site));
                break;

            case R.id.btnLocacao:
                startActivity(new Intent(this, Locacao.class));
                finish();
                break;



        }
    }


}
