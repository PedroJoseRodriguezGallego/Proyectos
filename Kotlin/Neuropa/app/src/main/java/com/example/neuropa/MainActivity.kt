package com.example.neuropa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity()
{
    val paises = mutableMapOf<String,String>(
        "Alemania" to "Berlín",
        "Austria" to "Viena",
        "Bulgaria" to "Sofia",
        "Chipre" to "Nicosia",
        "Croacia" to "Zagreb",
        "Dinamarca" to "Copenhague",
        "Eslovaquia" to "Bratislavia",
        "Eslovenia" to "Luibliana",
        "España" to "Madrid",
        "Estonia" to "Tallín",
        "Bélgica" to "Bruselas",
        "Finlandia" to "Helsinki",
        "Francia" to "París",
        "Grecia" to "Atenas",
        "Hungría" to "Budapest",
        "Irlanda" to "Dublín",
        "Italia" to "Roma",
        "Letonia" to "Riga",
        "Lituania" to "Vilna",
        "Luxemburgo" to "Luxemburgo",
        "Malta" to "La Valeta",
        "Países Bajos" to "Ámsterdam",
        "Polonia" to "Varsovia",
        "Portugal" to "Lisboa",
        "República Checa" to "Praga",
        "Rumanía" to "Bucarest",
        "Suecia" to "Estocolmo")

    val opciones = mutableMapOf<String,String>(
        "Alemania" to "Berlín",
        "Austria" to "Viena",
        "Bulgaria" to "Sofia",
        "Chipre" to "Nicosia",
        "Croacia" to "Zagreb",
        "Dinamarca" to "Copenhague",
        "Eslovaquia" to "Bratislavia",
        "Eslovenia" to "Luibliana",
        "España" to "Madrid",
        "Estonia" to "Tallín",
        "Bélgica" to "Bruselas",
        "Finlandia" to "Helsinki",
        "Francia" to "París",
        "Grecia" to "Atenas",
        "Hungría" to "Budapest",
        "Irlanda" to "Dublín",
        "Italia" to "Roma",
        "Letonia" to "Riga",
        "Lituania" to "Vilna",
        "Luxemburgo" to "Luxemburgo",
        "Malta" to "La Valeta",
        "Países Bajos" to "Ámsterdam",
        "Polonia" to "Varsovia",
        "Portugal" to "Lisboa",
        "República Checa" to "Praga",
        "Rumanía" to "Bucarest",
        "Suecia" to "Estocolmo")


    var paisActual = ""
    val random = java.util.Random()
    var aciertos = 0
    var fallos = 0
    var intentos = 0
    var comienzo = false



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton.setOnClickListener{
            try
            {
                jugar()
            }
                catch (e: Exception)
                {
                    if(paises.isEmpty() || paises.size == 1)
                    {
                        Toast.makeText(applicationContext, "$intentos países, $aciertos aciertos, $fallos fallos", Toast.LENGTH_LONG).show()
                        buttonText.text = "Ver resultado"
                        textView.text = "Fin del juego"

                        paisText.visibility = View.INVISIBLE
                        radioButtonGroup.visibility = View.INVISIBLE
                    }
                        else
                        {
                            intentos++
                            fallos++
                            siguiente()
                        }

                }
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

                if(radioElegido.text == paises[paisActual])
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



    private fun siguiente()
    {
        if(paises.isEmpty())
        {
            Toast.makeText(applicationContext, "$intentos países, $aciertos aciertos, $fallos fallos", Toast.LENGTH_LONG).show()
            paisText.text = "Fin del juego"
        }
            else
            {
                paises.remove(paisActual)
                paisActual = paises.entries.elementAt(random.nextInt(paises.size)).key
                paisText.text = paisActual
                prepararOpciones()
            }
    }


    private fun prepararOpciones()
    {
        radioButton1.text = opciones.entries.elementAt(random.nextInt(opciones.size)).value
        radioButton2.text = opciones.entries.elementAt(random.nextInt(opciones.size)).value
        radioButton3.text = opciones.entries.elementAt(random.nextInt(opciones.size)).value
        radioButton4.text = opciones.entries.elementAt(random.nextInt(opciones.size)).value

        if((radioButton1.text != paises[paisActual] && radioButton2.text != paises[paisActual] && radioButton3.text != paises[paisActual] && radioButton4.text != paises[paisActual]) || (radioButton1.text == radioButton2.text || radioButton1.text == radioButton3.text || radioButton1.text == radioButton4.text || radioButton2.text == radioButton3.text || radioButton2.text == radioButton2 || radioButton3.text == radioButton4.text) )
        {
            prepararOpciones()
        }
    }

}