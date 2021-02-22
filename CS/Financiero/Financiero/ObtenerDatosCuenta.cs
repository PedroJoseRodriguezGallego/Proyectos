using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;

namespace Financiero
{

    class ObtenerDatosCuenta
    {

        public String generarDigitoControl (Cuenta cuenta)
        {
            String fdigControl;
            int digCont1 = 0, digCont2 = 0, x, y = 0;
            int[] constantes = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };

            // Calculamos el primer dígito de control

            for (x = 2; x <= 5; x++)
            {
                digCont1 = digCont1 + constantes[x] * (int)Char.GetNumericValue(cuenta.Entidad[y]);
                y++;
            }

            y = 0;
            for (x = 6; x < constantes.Length; x++)
            {
                digCont1 = digCont1 + constantes[x] * (int)Char.GetNumericValue(cuenta.Sucursal[y]);
                y++;
            }
            digCont1 = 11 - (digCont1 % 11);

            if (digCont1 == 10)
            {
                digCont1 = 1;
            }
            else if (digCont1 == 11)
            {
                digCont1 = 0;
            }

            // Calculamos el segundo dígito de control

            y = 0;
            for (x = 0; x < constantes.Length; x++)
            {
                digCont2 = digCont2 + constantes[x] * (int)Char.GetNumericValue(cuenta.NumCuenta[y]);
                y++;
            }
            digCont2 = 11 - (digCont2 % 11);

            if (digCont2 == 10)
            {
                digCont2 = 1;
            }
            else if (digCont2 == 11)
            {
                digCont2 = 0;
            }

            // Finalmente obtenemos los dos dígitos de control como cadena

            fdigControl = digCont1.ToString() + digCont2.ToString();
            cuenta.Dc = fdigControl;

            return fdigControl;
        }

        public String generarIban (Cuenta cuenta)
        {
            String digTotal = cuenta.Entidad + cuenta.Sucursal + cuenta.Dc + cuenta.NumCuenta + 142800;
            int m = 0;
            int fdigIBAN;
            String fdigitosIBAN;
            for (int i = 0; i < digTotal.Length; ++i)
            {
                m = (m * 10 + (int)Char.GetNumericValue(digTotal[i])) % 97;
            }
            fdigIBAN = 98 - m;

            if ((fdigIBAN >= 0) && (fdigIBAN <= 9))
            {
                fdigitosIBAN = "0" + fdigIBAN.ToString();
            }
            else
            {
                fdigitosIBAN = fdigIBAN.ToString();
            }

            cuenta.Iban = fdigitosIBAN;
            return fdigitosIBAN;
        }

    }
}
