package com.example.capitalesafrica

import java.io.Serializable

class Resultado : Serializable
{
    var intentos: Int? = 0
    var aciertos: Int? = 0
    var fallos: Int? = 0

    constructor(fintentos: Int, faciertos: Int, ffallos: Int)
    {
        this.intentos = fintentos
        this.aciertos = faciertos
        this.fallos = ffallos
    }
}