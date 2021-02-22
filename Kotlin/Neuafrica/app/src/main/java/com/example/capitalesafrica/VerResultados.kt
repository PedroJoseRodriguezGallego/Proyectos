package com.example.capitalesafrica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ver_resultados.*

class VerResultados : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_resultados)

        var result = intent.extras?.get("valoresResultado") as Resultado

        fallosText.text = result.fallos.toString()
        aciertosText.text = result.aciertos.toString()
        intentosText.text = result.intentos.toString()

        backButton.setOnClickListener {
            val actividadPrincipal = Intent(this@VerResultados, MainActivity::class.java) //Pasamos la actividad actual y la clase de la nueva actividad
            startActivity(actividadPrincipal) //Iniciamos la actividad principal
        }
    }
}