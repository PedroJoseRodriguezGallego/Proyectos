using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;

namespace Financiero
{
    class ObtenerDatosTarjeta
    {

        public String generarNumTarjeta(String primerDigito)
        {
            int i = 0;
            String digitosRandom = generarDigitosRandom(primerDigito);
            String digitos = primerDigito + digitosRandom;
            String resultPares = "";
            int digitoMultiplicado;

            for (i = digitos.Length - 1; i >= 0; i = i - 2)
            {
                digitoMultiplicado = ((int)Char.GetNumericValue(digitos[i])) * 2;
                if (digitoMultiplicado > 9)
                {
                    digitoMultiplicado = digitoMultiplicado - 9;
                }
                resultPares = resultPares + digitoMultiplicado.ToString();
            }

            int j = 0;
            int sumaImpares = 0;

            for (j = 1; j < digitos.Length; j = j + 2)
            {
                sumaImpares = sumaImpares + (int)Char.GetNumericValue(digitos[j]);
            }

            int sumaTotal = 0;
            i = 0;

            for (i = 0; i < resultPares.Length; i++)
            {
                sumaTotal = sumaTotal + (int)Char.GetNumericValue(resultPares[i]);
            }

            sumaTotal = sumaTotal + sumaImpares;
            sumaTotal = sumaTotal * 9;
            String suma = sumaTotal.ToString();
            String digitoVerificador = suma[suma.Length - 1].ToString();

            String numeroTarjeta = digitos + digitoVerificador;
            return numeroTarjeta;
        }


        private String generarDigitosRandom(String primerDigito)
        {
            int i;
            String numerosRandom = "";
            int x = 0;

            if (primerDigito.Equals("4"))
                x = 14; // Visa
            else
                x = 13; // Mastercard & American

            for (i = 0; i < x; i++)
            {
                Random rnd = new Random();
                numerosRandom = numerosRandom + rnd.Next(0, 9).ToString();
            }

            return numerosRandom;
        }

    }
}
