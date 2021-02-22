package com.example.capitalesafrica

class Pais
{
    var id: Int? = 0
    var pais: String? = null
    var capital: String? = null

    constructor(fid:Int, fpais: String, fcapital: String)
    {
        this.id = fid
        this.pais = fpais
        this.capital = fcapital
    }
}