package com.example.capitalesafrica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity()
{

     val paisesTotales = mutableMapOf<String,String>( //54 paises
            "Angola" to "Luanda",
            "Argelia" to "Argel",
            "Benin" to "Porto Novo",
            "Botsuana" to "Gaborone",
            "Burkina Faso" to "Uagadugú",
            "Burundi" to "Buyumbura",
            "Cabo Verde" to "Praia",
            "Camerún" to "Yaundé",
            "Chad" to "Yamena",
            "Comoras" to "Moroni",
            "Congo" to "Brazzaville",
            "Costa de Marfil" to "Yamusukro",
            "Egipto" to "El Cairo",
            "Eritrea" to "Asmara",
            "Esuatini" to "Mbabane",
            "Etiopía" to "Adís Abeba",
            "Gabón" to "Libreville",
            "Gambia" to "Banjul",
            "Ghana" to "Acra",
            "Guinea" to "Conakry",
            "Guinea Bissau" to "Bissau",
            "Guinea Ecuatorial" to "Malabo",
            "Kenya" to "Nairobi",
            "Lesoto" to "Maseru",
            "Liberia" to "Monrovia",
            "Libia" to "Trípoli",
            "Madagascar" to "Antananarivo",
            "Malauí" to "Lilongüe",
            "Malí" to "Bamako",
            "Marruecos" to "Rabat",
            "Mauricio" to "Port Louis",
            "Mauritania" to "Nuakchot",
            "Mozambique" to "Maputo",
            "Namibia" to "Windhoek",
            "Níger" to "Niamey",
            "Nigeria" to "Abuya",
            "República Centroafricana" to "Bangui",
            "República Democrática del Congo" to "Kinshasa",
            "Ruanda" to "Kigali",
            "Santo Tomé y Príncipe" to "Santo Tomé",
            "Senegal" to "Dakar",
            "Seychelles" to "Victoria",
            "Sierra Leona" to "Freetown",
            "Somalia" to "Mogadiscio",
            "Sudáfrica" to "Ciudad del Cabo",
            "Sudán" to "Jartum",
            "Sudán del Sur" to "Yuba",
            "Tanzania" to "Dodoma",
            "Togo" to "Lomé",
            "Túnez" to "Túnez",
            "Uganda" to "Kampala",
            "Yibuti" to "Yibuti",
            "Zambia" to "Lusaka",
            "Zimbabue" to "Harare")

    val paises = mutableMapOf<String,String>( //54 paises
            "Zambia" to "Lusaka",
            "Zimbabue" to "Harare")

    var paisActual = ""
    var aciertos = 0
    var fallos = 0
    var intentos = 0
    var comienzo = false

    val gestorBBDDpaises = MyDBHandler(this, "neuafrica", null, 1)
    val gestorBBDDopciones = MyDBHandler(this, "neuafricaOpciones", null, 1)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        insertarTodos()

        imageButton.setOnClickListener{
            try
            {
                jugar()
            }
                catch (e: Exception) //No marcar radioButton, lista vacia
                {
                    if(gestorBBDDpaises.obtenerTamanoBBDD() > 1) //Si aun quedan mas opciones
                    {
                        intentos++
                        fallos++
                        Toast.makeText(applicationContext, "Respuesta nula", Toast.LENGTH_SHORT).show()
                        siguiente()
                    }
                }
        }

        resultButton.setOnClickListener {
                Log.v(":::", "Has pulsado el boton de resultado")
                val actividadResultados = Intent(this@MainActivity, VerResultados::class.java) //Pasamos la actividad actual y la clase de la nueva actividad

                var result = Resultado(intentos, aciertos, fallos)
                actividadResultados.putExtra("valoresResultado", result) //Pasamos un objeto con el nombre de valoresResultado

                startActivity(actividadResultados) //Lanzamos la otra actividad
        }
    }


    private fun jugar()
    {
        if (!comienzo)
        {
            iniciarJuego()
        }
            else
            {
                val eleccion = radioButtonGroup.checkedRadioButtonId
                val radioElegido: RadioButton = findViewById(eleccion)

                if(radioElegido.text == gestorBBDDpaises.encontrarPaisPorNombre(paisActual)?.capital.toString())
                {
                    intentos++
                    aciertos++
                    Toast.makeText(applicationContext, "$paisActual y ${radioElegido.text} correcto", Toast.LENGTH_SHORT).show()
                }
                    else
                    {
                        intentos++
                        fallos++
                        Toast.makeText(applicationContext, "$paisActual y ${radioElegido.text} incorrecto", Toast.LENGTH_SHORT).show()
                    }
            }

        radioButtonGroup.clearCheck()
        siguiente()
    }


    private fun iniciarJuego()
    {
        buttonText.text = "Mostrar otro País"
        paisText.visibility = View.VISIBLE
        radioButtonGroup.visibility = View.VISIBLE
        comienzo = true
    }


    private fun siguiente() //Continua revisando el codigo por aqui
    {
        if(gestorBBDDpaises.obtenerTamanoBBDD() <= 1) //Si hemos completado el juego
        {
            Log.v(":::","BBDD VACIA")
            textView.text = "Has terminado"
            buttonText.visibility = View.INVISIBLE
            paisText.visibility = View.INVISIBLE
            radioButtonGroup.visibility = View.INVISIBLE
            resultButton.visibility = View.VISIBLE
            imageButton.visibility = View.INVISIBLE
        }
            else
            {
                gestorBBDDpaises.borrarPais(paisActual)

                var id = (0..54).random()
                var intentoPais = gestorBBDDpaises.encontrarPaisPorID(id)?.pais.toString()

                while(intentoPais == "null")
                {
                    id = (0..54).random()
                    intentoPais = gestorBBDDpaises.encontrarPaisPorID(id)?.pais.toString()
                }

                paisActual = gestorBBDDpaises.encontrarPaisPorID(id)?.pais.toString()
                paisText.text = paisActual

                prepararOpciones()
            }
    }


    private fun prepararOpciones()
    {
        radioButton1.text = gestorBBDDopciones.encontrarPaisPorID((0..54).random())?.capital.toString()
        radioButton2.text = gestorBBDDopciones.encontrarPaisPorID((0..54).random())?.capital.toString()
        radioButton3.text = gestorBBDDopciones.encontrarPaisPorID((0..54).random())?.capital.toString()
        radioButton4.text = gestorBBDDopciones.encontrarPaisPorID((0..54).random())?.capital.toString()

        var respuestaCorrecta = gestorBBDDpaises.encontrarPaisPorNombre(paisActual)?.capital.toString()

        if( (radioButton1.text != respuestaCorrecta && radioButton2.text != respuestaCorrecta && radioButton3.text != respuestaCorrecta && radioButton4.text != respuestaCorrecta) || (radioButton1.text == radioButton2.text || radioButton1.text == radioButton3.text || radioButton1.text == radioButton4.text || radioButton2.text == radioButton3.text || radioButton2.text == radioButton4.text || radioButton3.text == radioButton4.text) || (radioButton1.text == "null" || radioButton2.text == "null" || radioButton3.text == "null" || radioButton4.text == "null") )
        {
            prepararOpciones()
        }
    }


    private fun insertarTodos()
    {
        var indice = 1

        gestorBBDDpaises.resetearTabla()
        gestorBBDDopciones.resetearTabla()

        for ((pais, capital) in paises)
        {
            gestorBBDDpaises.anadirPais(Pais(indice,pais,capital))
            indice++
        }

        indice = 1
        for ((pais, capital) in paisesTotales)
        {
            gestorBBDDopciones.anadirPais(Pais(indice,pais,capital))
            indice++
        }
    }

}