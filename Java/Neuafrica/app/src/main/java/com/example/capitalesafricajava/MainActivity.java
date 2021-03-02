package com.example.capitalesafricajava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    HashMap<String, String> paises = new HashMap<String, String>();
    HashMap<String, String> opciones = new HashMap<String, String>();

    DbHandler dbHandlerPaises = new DbHandler(MainActivity.this,"capitalesAfricaPaises",1);
    DbHandler dbHandlerOpciones = new DbHandler(MainActivity.this,"capitalesAfricaOpciones",1);
    Random random = new Random();

    ImageButton btnEmpezar;
    Button btnCambiarActividad;
    RadioGroup radioButtonGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView txtPais;
    TextView buttonText;
    TextView textView;

    String paisActual = "";
    int aciertos = 0;
    int fallos = 0;
    int intentos = 0;
    boolean comienzo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarElementosGraficos();
        iniciarBaseDatos();

        btnEmpezar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    jugar();
                }
                    catch (Exception e)
                    {
                        if(dbHandlerPaises.obtenerTamano() > 0)
                        {
                            intentos++;
                            fallos++;
                            siguiente();
                        }
                    }
            }
        });

        btnCambiarActividad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.v(":::","Has pulsado el boton ver resultados");
                Resultado resultado = new Resultado(intentos,aciertos,fallos);
                Intent intent = new Intent(MainActivity.this, Resultados.class);
                intent.putExtra("valoresResultado", resultado);
                startActivity(intent);
            }
        });
    }

    public void jugar()
    {
        if (!comienzo)
        {
            iniciarJuego();
        }
        else
        {
            int eleccion = radioButtonGroup.getCheckedRadioButtonId();
            RadioButton radioElegido = findViewById(eleccion);

            if(radioElegido.getText().equals(dbHandlerPaises.obtenerPaisPorNombre(paisActual).getCapital())) //Posible problema nulo
            {
                intentos++;
                aciertos++;
            }
                else
                {
                    intentos++;
                    fallos++;
                }
        }

        radioButtonGroup.clearCheck();
        siguiente();
    }

    public void siguiente()
    {
        if(dbHandlerPaises.obtenerTamano() <= 1)
        {
            btnCambiarActividad.setVisibility(View.VISIBLE);
            btnEmpezar.setVisibility(View.INVISIBLE);
            radioButtonGroup.setVisibility(View.INVISIBLE);
            txtPais.setVisibility(View.INVISIBLE);
            buttonText.setVisibility(View.INVISIBLE);
            textView.setText("Fin del juego");
        }
            else
            {
                dbHandlerPaises.eliminarPais(paisActual);
                int id = random.nextInt(54 - 1 + 1) + 1;
                String intentoPais = dbHandlerPaises.obtenerPaisPorID(id).getPais();

                while(intentoPais.equals("error"))
                {
                    id = random.nextInt(54 - 1 + 1) + 1;
                    intentoPais = dbHandlerPaises.obtenerPaisPorID(id).getPais();
                }

                paisActual = dbHandlerPaises.obtenerPaisPorID(id).getPais();
                txtPais.setText(paisActual);
                prepararOpciones();
            }
    }

    public void prepararOpciones()
    {
        radioButton1.setText(dbHandlerOpciones.obtenerPaisPorID(random.nextInt(54 - 1 + 1) + 1).getCapital());
        radioButton2.setText(dbHandlerOpciones.obtenerPaisPorID(random.nextInt(54 - 1 + 1) + 1).getCapital());
        radioButton3.setText(dbHandlerOpciones.obtenerPaisPorID(random.nextInt(54 - 1 + 1) + 1).getCapital());
        radioButton4.setText(dbHandlerOpciones.obtenerPaisPorID(random.nextInt(54 - 1 + 1) + 1).getCapital());

        String respuestaCorrecta = dbHandlerPaises.obtenerPaisPorNombre(paisActual).getCapital();
        Log.v(":::","Respuesta correcta : " + respuestaCorrecta);

        if( (!radioButton1.getText().equals(respuestaCorrecta)  && !radioButton2.getText().equals(respuestaCorrecta)  && !radioButton3.getText().equals(respuestaCorrecta)  && !radioButton4.getText().equals(respuestaCorrecta)) || (radioButton1.getText().equals(radioButton2.getText()) || radioButton1.getText().equals(radioButton3.getText()) || radioButton1.getText().equals(radioButton4.getText()) || radioButton2.getText().equals(radioButton3.getText()) || radioButton2.getText().equals(radioButton4.getText()) || radioButton3.getText().equals(radioButton4.getText()) ) || (radioButton1.getText() == null || radioButton2.getText() == null || radioButton3.getText() == null || radioButton4.getText() == null) || (radioButton1.getText() == "null" || radioButton2.getText() == "null" || radioButton3.getText() == "null" || radioButton4.getText() == "null") )
        {
            prepararOpciones();
        }
    }

    public void iniciarJuego()
    {
        buttonText.setText("Mostrar otro País");
        txtPais.setVisibility(View.VISIBLE);
        radioButtonGroup.setVisibility(View.VISIBLE);
        comienzo = true;
    }

    public void iniciarElementosGraficos()
    {
        btnEmpezar = (ImageButton) findViewById(R.id.btnEmpezar);
        btnCambiarActividad = (Button) findViewById(R.id.btnCambiarActividad);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        txtPais = (TextView) findViewById(R.id.txtPais);
        buttonText = (TextView) findViewById(R.id.buttonText);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void iniciarBaseDatos()
    {
        paises.put("Angola", "Luanda");
        paises.put("Argelia", "Argel");
        paises.put("Benin", "Porto Novo");
        paises.put("Botsuana", "Gaborone");
        paises.put("Burkina F.", "Uagadugú");
        paises.put("Burundi", "Buyumbura");
        paises.put("Cabo Verde", "Praia");
        paises.put("Camerún", "Yaundé");
        paises.put("Chad", "Yamena");
        paises.put("Comoras", "Moroni");
        paises.put("Congo", "Brazzaville");
        paises.put("C.Marfil", "Yamusukro");
        paises.put("Egipto", "El Cairo");
        paises.put("Eritrea", "Asmara");
        paises.put("Esuatini", "Mbabane");
        paises.put("Etiopía", "Adís Abeba");
        paises.put("Gabón", "Libreville");
        paises.put("Gambia", "Banjul");
        paises.put("Ghana", "Acra");
        paises.put("Guinea", "Conakry");
        paises.put("Guinea Bissau", "Bissau");
        paises.put("Guinea Ecuatorial", "Malabo");
        paises.put("Kenya", "Nairobi");
        paises.put("Lesoto", "Maseru");
        paises.put("Liberia", "Monrovia");
        paises.put("Libia", "Trípoli");
        paises.put("Madagascar", "Antananarivo");
        paises.put("Malauí", "Lilongüe");
        paises.put("Malí", "Bamako");
        paises.put("Marruecos", "Rabat");
        paises.put("Mauricio", "Port Louis");
        paises.put("Mauritania", "Nuakchot");
        paises.put("Mozambique", "Maputo");
        paises.put("Namibia", "Windhoek");
        paises.put("Níger", "Niamey");
        paises.put("Nigeria", "Abuya");
        paises.put("República Centroafricana", "Bangui");
        paises.put("R. Democrática del Congo", "Kinshasa");
        paises.put("Ruanda", "Kigali");
        paises.put("Santo Tomé y Príncipe", "Santo Tomé");
        paises.put("Senegal", "Dakar");
        paises.put("Seychelles", "Victoria");
        paises.put("Sierra Leona", "Freetown");
        paises.put("Somalia", "Mogadiscio");
        paises.put("Sudáfrica", "Ciudad del Cabo");
        paises.put("Sudán", "Jartum");
        paises.put("Sudán del Sur", "Yuba");
        paises.put("Tanzania", "Dodoma");
        paises.put("Togo", "Lomé");
        paises.put("Túnez", "Túnez");
        paises.put("Uganda", "Kampala");
        paises.put("Yibuti", "Yibuti");
        paises.put("Zambia", "Lusaka");
        paises.put("Zimbabue", "Harare");

        opciones.put("Angola", "Luanda");
        opciones.put("Argelia", "Argel");
        opciones.put("Benin", "Porto Novo");
        opciones.put("Botsuana", "Gaborone");
        opciones.put("Burkina F.", "Uagadugú");
        opciones.put("Burundi", "Buyumbura");
        opciones.put("Cabo Verde", "Praia");
        opciones.put("Camerún", "Yaundé");
        opciones.put("Chad", "Yamena");
        opciones.put("Comoras", "Moroni");
        opciones.put("Congo", "Brazzaville");
        opciones.put("C.Marfil", "Yamusukro");
        opciones.put("Egipto", "El Cairo");
        opciones.put("Eritrea", "Asmara");
        opciones.put("Esuatini", "Mbabane");
        opciones.put("Etiopía", "Adís Abeba");
        opciones.put("Gabón", "Libreville");
        opciones.put("Gambia", "Banjul");
        opciones.put("Ghana", "Acra");
        opciones.put("Guinea", "Conakry");
        opciones.put("Guinea Bissau", "Bissau");
        opciones.put("Guinea Ecuatorial", "Malabo");
        opciones.put("Kenya", "Nairobi");
        opciones.put("Lesoto", "Maseru");
        opciones.put("Liberia", "Monrovia");
        opciones.put("Libia", "Trípoli");
        opciones.put("Madagascar", "Antananarivo");
        opciones.put("Malauí", "Lilongüe");
        opciones.put("Malí", "Bamako");
        opciones.put("Marruecos", "Rabat");
        opciones.put("Mauricio", "Port Louis");
        opciones.put("Mauritania", "Nuakchot");
        opciones.put("Mozambique", "Maputo");
        opciones.put("Namibia", "Windhoek");
        opciones.put("Níger", "Niamey");
        opciones.put("Nigeria", "Abuya");
        opciones.put("República Centroafricana", "Bangui");
        opciones.put("R. Democrática del Congo", "Kinshasa");
        opciones.put("Ruanda", "Kigali");
        opciones.put("Santo Tomé y Príncipe", "Santo Tomé");
        opciones.put("Senegal", "Dakar");
        opciones.put("Seychelles", "Victoria");
        opciones.put("Sierra Leona", "Freetown");
        opciones.put("Somalia", "Mogadiscio");
        opciones.put("Sudáfrica", "Ciudad del Cabo");
        opciones.put("Sudán", "Jartum");
        opciones.put("Sudán del Sur", "Yuba");
        opciones.put("Tanzania", "Dodoma");
        opciones.put("Togo", "Lomé");
        opciones.put("Túnez", "Túnez");
        opciones.put("Uganda", "Kampala");
        opciones.put("Yibuti", "Yibuti");
        opciones.put("Zambia", "Lusaka");
        opciones.put("Zimbabue", "Harare");

        int indice = 1;

        dbHandlerPaises.resetear();
        dbHandlerOpciones.resetear();

        for (Map.Entry<String, String> pair: paises.entrySet()) {
            dbHandlerPaises.insertarPais(new Pais(indice, pair.getKey(), pair.getValue()));
            indice++;
        }

        indice = 1;
        for (Map.Entry<String, String> pair: opciones.entrySet()) {
            dbHandlerOpciones.insertarPais(new Pais(indice, pair.getKey(), pair.getValue()));
            indice++;
        }
    }
}