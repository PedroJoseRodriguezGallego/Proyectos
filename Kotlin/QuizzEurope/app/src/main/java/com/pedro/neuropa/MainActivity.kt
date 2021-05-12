package com.pedro.neuropa

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.gms.ads.LoadAdError
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerAdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity()
{
    val paises = mutableMapOf<String, String>(
        "Alemania" to "Berlín",
        "Austria" to "Viena",
        "Bélgica" to "Bruselas",
        "Bulgaria" to "Sofia",
        "Chipre" to "Nicosia",
        "Croacia" to "Zagreb",
        "Dinamarca" to "Copenhague",
        "Eslovaquia" to "Bratislavia",
        "Eslovenia" to "Luibliana",
        "España" to "Madrid",
        "Estonia" to "Tallín",
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
        "Suecia" to "Estocolmo"
    )

    val opciones = mutableMapOf<String, String>(
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
        "Suecia" to "Estocolmo"
    )

    var paisActual = ""
    val random = java.util.Random()
    var aciertos = 0
    var fallos = 0
    var intentos = 0
    var comienzo = false
    var finalConfirmado = false

    var mediaPlayer: MediaPlayer? = null

    private var mInterstitialAd: InterstitialAd? = null
    lateinit var mAdManagerAdView : AdManagerAdView

    //Banner example = ca-app-pub-3940256099942544/6300978111
    //Video example = ca-app-pub-3940256099942544/1033173712
    //Manifest example = ca-app-pub-3940256099942544~3347511713

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cargarAnuncios()

        imageButton.setOnClickListener {
            try
            {
                jugar()
            }

            catch (e: Exception) //Cuando hemos acabado el juego
            {
                if(paises.size > 1) //Si no hemos terminado
                {
                    playSound("wrong")
                    intentos++
                    fallos++
                    Toast.makeText(applicationContext, "Respuesta nula", Toast.LENGTH_SHORT).show()
                    siguiente()
                }
                    else //Si hemos terminado
                    {
                        if(finalConfirmado)
                        {
                            reiniciar()
                        }
                            else
                            {
                                buttonText.text = "Reiniciar"

                                textView2.visibility = View.VISIBLE
                                textView3.visibility = View.VISIBLE
                                textView4.visibility = View.VISIBLE

                                textView10.visibility = View.VISIBLE
                                textView11.visibility = View.VISIBLE
                                textView12.visibility = View.VISIBLE

                                textView10.text = intentos.toString()
                                textView11.text = aciertos.toString()
                                textView12.text = fallos.toString()

                                imageButton.setImageResource(R.drawable.refresh)
                                imageView.setImageResource(R.drawable.europeanmap)

                                paisText.visibility = View.INVISIBLE
                                radioButtonGroup.visibility = View.INVISIBLE

                                textView.visibility = View.VISIBLE
                                textView.text = "Resultados"

                                finalConfirmado = true
                                mInterstitialAd?.show(this) //Mostrar el anuncio si esta cargado
                            }
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

            if (radioElegido.text == paises[paisActual])
            {
                playSound("correct")
                intentos++
                aciertos++
                Toast.makeText(applicationContext,"$paisActual y ${radioElegido.text} correcto",Toast.LENGTH_SHORT).show()
            }
                else
                {
                    playSound("wrong")
                    intentos++
                    fallos++
                    Toast.makeText(applicationContext,"$paisActual y ${radioElegido.text} incorrecto",Toast.LENGTH_SHORT).show()
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
        textView.visibility = View.INVISIBLE
        comienzo = true
    }


    private fun siguiente()
    {
        if (paises.isNotEmpty())
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

        val respuesta = paises[paisActual].toString()

        if ((radioButton1.text != respuesta && radioButton2.text != respuesta && radioButton3.text != respuesta && radioButton4.text != respuesta) || (radioButton1.text == radioButton2.text || radioButton1.text == radioButton3.text || radioButton1.text == radioButton4.text || radioButton2.text == radioButton3.text || radioButton2.text == radioButton4 || radioButton3.text == radioButton4.text))
        {
            prepararOpciones()
        }

        when (paisActual)
        {
            "Alemania" -> imageView.setImageResource(R.drawable.alemania)
            "Austria" -> imageView.setImageResource(R.drawable.austria)
            "Bélgica" -> imageView.setImageResource(R.drawable.belgica)
            "Bulgaria" -> imageView.setImageResource(R.drawable.bulgaria)
            "Chipre" -> imageView.setImageResource(R.drawable.chipre)
            "Croacia" -> imageView.setImageResource(R.drawable.croacia)
            "Dinamarca" -> imageView.setImageResource(R.drawable.dinamarca)
            "Eslovaquia" -> imageView.setImageResource(R.drawable.eslovaquia)
            "Eslovenia" -> imageView.setImageResource(R.drawable.eslovenia)
            "España" -> imageView.setImageResource(R.drawable.espana)
            "Estonia" -> imageView.setImageResource(R.drawable.estonia)
            "Finlandia" -> imageView.setImageResource(R.drawable.finlandia)
            "Francia" -> imageView.setImageResource(R.drawable.francia)
            "Grecia" -> imageView.setImageResource(R.drawable.grecia)
            "Hungría" -> imageView.setImageResource(R.drawable.hungria)
            "Irlanda" -> imageView.setImageResource(R.drawable.irlanda)
            "Italia" -> imageView.setImageResource(R.drawable.italia)
            "Letonia" -> imageView.setImageResource(R.drawable.letonia)
            "Lituania" -> imageView.setImageResource(R.drawable.lituania)
            "Luxemburgo" -> imageView.setImageResource(R.drawable.luxemburgo)
            "Malta" -> imageView.setImageResource(R.drawable.malta)
            "Países Bajos" -> imageView.setImageResource(R.drawable.paisesbajos)
            "Polonia" -> imageView.setImageResource(R.drawable.polonia)
            "Portugal" -> imageView.setImageResource(R.drawable.portugal)
            "República Checa" -> imageView.setImageResource(R.drawable.republicacheca)
            "Rumanía" -> imageView.setImageResource(R.drawable.rumania)
            "Suecia" -> imageView.setImageResource(R.drawable.suecia)
        }
    }


    fun playSound(fuente: String?)
    {
        if (fuente == "correct")
        {
            if (mediaPlayer == null)
            {
                mediaPlayer = MediaPlayer.create(this, R.raw.correct)
                mediaPlayer!!.start()
            }
                else
                {
                    mediaPlayer!!.start()
                }

            mediaPlayer = null
        }
            else
            {
                if (mediaPlayer == null)
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.wrong)
                    mediaPlayer!!.start()
                }
                    else
                    {
                        mediaPlayer!!.start()
                    }

                mediaPlayer = null
            }
    }


    fun reiniciar()
    {
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent)
    }


    fun cargarAnuncios()
    {
        val adRequestBanner = AdManagerAdRequest.Builder().build()
        mAdManagerAdView = findViewById(R.id.adManagerAdView)
        mAdManagerAdView.loadAd(adRequestBanner)

        val adRequest = AdManagerAdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback(){
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                mInterstitialAd = null
            }
        })
    }
}