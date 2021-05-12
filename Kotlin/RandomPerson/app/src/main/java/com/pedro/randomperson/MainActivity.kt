package com.pedro.randomperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerAdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_main.*;
import java.lang.Exception

class MainActivity : AppCompatActivity()
{
    private var contador = 0
    var candidatos = mutableListOf<Person>()

    private var mInterstitialAd: InterstitialAd? = null
    lateinit var mAdManagerAdView : AdManagerAdView

    //Banner example = ca-app-pub-3940256099942544/6300978111
    //Video example = ca-app-pub-3940256099942544/1033173712
    //Manifest example = ca-app-pub-3940256099942544~3347511713

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adRequestBanner = AdManagerAdRequest.Builder().build()
        mAdManagerAdView = findViewById(R.id.adManagerAdView)
        mAdManagerAdView.loadAd(adRequestBanner)

        cargarAnuncioVideo()

        randomPersonButton.setOnClickListener{
            try
            {
                val random = java.util.Random()
                val randomSelected = random.nextInt(candidatos.count())
                choosenPerson.text = candidatos[randomSelected].name
                candidatos.removeAt(randomSelected)
            }

                catch (e: Exception)
                {
                    choosenPerson.text = "No hay mas candidatos"
                }

                finally
                {
                    cargarRecyclerView()
                    comprobarAnuncio()
                }
        }

        addPersonButton.setOnClickListener{
            if(!newPersonText.text.isNullOrEmpty())
            {
                val newPerson = newPersonText.text.toString()
                candidatos.add(Person(newPerson))
                newPersonText.text?.clear()
                cargarRecyclerView()
                comprobarAnuncio()
            }
        }
    }

    fun cargarAnuncioVideo()
    {
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

    fun comprobarAnuncio()
    {
        if(contador == 5)
        {
            mInterstitialAd?.show(this)
            cargarAnuncioVideo()
            contador = 0
        }
            else
            {
                contador++
            }
    }

    fun cargarRecyclerView()
    {
        recyclerPeople.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(candidatos)
        recyclerPeople.adapter = adapter
    }
}