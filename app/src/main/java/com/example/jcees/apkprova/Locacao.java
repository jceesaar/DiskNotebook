package com.example.jcees.apkprova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Locacao extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button btnExit, btnVoltar, btnNext;
    private Spinner spnSO;
    private String spnSOS;

//    private EditText edtSO;
    private EditText edtTela;
    private EditText edtDias;

    private EditText Custo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacao);

        spnSO = (Spinner)findViewById(R.id.spnSO);
        String[] SOs = new String[]{"Windows", "Linux", "MacOS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, SOs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSO.setAdapter(adapter);
        spnSO.setOnItemSelectedListener(this);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

//        edtSO = (EditText) findViewById(R.id.edtSO);
//        if (edtSO.getText().toString().length() == 0) {
//            edtSO.setError("Sistema Operacional*");
//        }
        edtTela = (EditText) findViewById(R.id.edtTela);
        if (edtTela.getText().toString().length() == 0) {
            edtTela.setError("Tamanho da Tela*");
        }
        edtDias = (EditText) findViewById(R.id.edtDias);
        if (edtDias.getText().toString().length() == 0) {
            edtDias.setError("Quantidade de Dias*");
        }
    }


    public  void onClick(View v) {

        Intent it = new Intent(this, Final.class);

        it.putExtra("sistema", spnSOS);
        it.putExtra("tela", edtTela.getText().toString());
        it.putExtra("dias", edtDias.getText().toString());

        switch (v.getId()) {

            case R.id.btnNext:
                startActivity(it);
                finish();
                break;

            case R.id.btnVoltar:
                startActivity(new Intent(this, Home.class));
                finish();
                break;

            case R.id.btnExit:
                finish();
                break;

        }


    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                spnSOS = spnSO.getItemAtPosition(0).toString();
                break;
            case 1:
                spnSOS = spnSO.getItemAtPosition(1).toString();
                break;
            case 2:
                spnSOS = spnSO.getItemAtPosition(2).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
