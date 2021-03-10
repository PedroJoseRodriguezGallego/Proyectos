using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gestion_FCT.modelo
{
    class Conexion
    {
        private MySqlConnection conex;
        private MySqlDataReader lector;
        private MySqlCommand cmd;
        private string getCadenaConexion()
        {
            string host = "server=80.59.11.241;";
            string port = "port=3306;";
            string db = "Database=DDI_E1;";
            string usuario = "user=DDI_E1;";
            string contra = "password=EzLCL9jopYDntRQr;";
            string cadena = string.Format("{0}{1}{2}{3}{4}", host, port, db, usuario, contra);
            return cadena;
        }

        public void setCmd(string sql)
        {
            cmd = new MySqlCommand(sql);
        }

        public MySqlCommand getCmd()
        {
            return cmd;
        }

        public void conectarBD()
        {
            conex = new MySqlConnection(getCadenaConexion());
            cmd.Connection = conex;
            conex.Open();
        }

        public void desconectarBD()
        {
            conex.Close();
            conex = null;
        }
    }
}
