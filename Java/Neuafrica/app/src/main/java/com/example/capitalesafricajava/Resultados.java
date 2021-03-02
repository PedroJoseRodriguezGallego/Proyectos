package com.example.capitalesafricajava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity
{
        @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        TextView txtIntentos = (TextView) findViewById(R.id.txtIntentos);
        TextView txtAciertos = (TextView) findViewById(R.id.txtAciertos);
        TextView txtFallos = (TextView) findViewById(R.id.txtFallos);

        Resultado resultado = (Resultado) getIntent().getExtras().getSerializable("valoresResultado");

        txtIntentos.setText(String.valueOf(resultado.getIntentos()));
        txtAciertos.setText(String.valueOf(resultado.getAciertos()));
        txtFallos.setText(String.valueOf(resultado.getFallos()));

        btnVolver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Resultados.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}