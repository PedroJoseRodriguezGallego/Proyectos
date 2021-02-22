using System;
using System.Collections.Generic;
using System.Text;

namespace Financiero
{
    class Cuenta
    {
        private String entidad;
        private String sucursal;
        private String dc;
        private String numCuenta;
        private String iban;

        public Cuenta(String entidad, String sucursal, String cuenta)
        {
            Entidad = entidad;
            Sucursal = sucursal;
            Dc = "";
            NumCuenta = cuenta;
            Iban = "";
        }

        public String Entidad { get; set; }

        public String Sucursal { get; set; }

        public String Dc { get; set; }

        public String NumCuenta { get; set; }

        public String Iban { get; set; }
    }
}

