using System;


namespace VisorWPF
{
    class Cuenta
    {
        public Cuenta(string fnumero, string ftitular, string ffecha, double fsaldo, string fnacionalidad)
        {
            Numero = fnumero;
            Titular = ftitular;
            Fecha = ffecha;
            Saldo = fsaldo;
            Nacionalidad = fnacionalidad;
        }

        string Numero { get; set; }

        string Titular { get; set; }

        string Fecha { get; set; }

        double Saldo { get; set; }

        string Nacionalidad { get; set; }
    }
}