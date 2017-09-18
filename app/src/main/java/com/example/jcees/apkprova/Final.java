package com.example.jcees.apkprova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Final extends AppCompatActivity implements View.OnClickListener{


    private Button btnVoltar, btnExit;
    private TextView txvSO, txvTela, txvDias, txvValor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);

        txvSO = (TextView) findViewById(R.id.txvSO);
        txvTela = (TextView) findViewById(R.id.txvTela);
        txvDias = (TextView) findViewById(R.id.txvDias);
        txvValor = (TextView) findViewById(R.id.txvValor);

        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("sistema") && bundle.containsKey("tela") && bundle.containsKey("dias")) {

            String valor = bundle.getString("sistema");
            String valor2 = bundle.getString("tela");
            String valor3 = bundle.getString("dias");
            int i = Integer.parseInt(valor3);
            int vl = i * 100;
            String vls = String.valueOf(vl);

            txvSO.setText(valor);
            txvTela.setText(valor2);
            txvDias.setText(valor3);
            txvValor.setText(vls);

            Toast.makeText(this, "Notebook com"+" "+ txvSO.getText().toString()+" "+ " e com: "+ " "+txvTela.getText().toString()+" "+"Polegadas será locado por:"+
                    " "+txvDias.getText().toString()+ " " +"dias, ao custo de"+" "+ txvValor.getText().toString() +" R$!", Toast.LENGTH_LONG).show();


        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnVoltar:
                startActivity(new Intent(this, Home.class));
                finish();
                break;

            case R.id.btnExit:
                finish();
                break;

        }
    }
}
