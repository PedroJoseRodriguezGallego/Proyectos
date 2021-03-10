using MySql.Data.MySqlClient;
using System;
using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace VisorWPF
{
    class GestionCuenta
    {
        public int index = 0;
        public int tam = 0;



        public void rellenarDatos()
        {
            eliminarTodosLosDatos();

            insertarDatos("0", "Pedro", "2001-08-15", "200", "Espanola");
            insertarDatos("1", "Antonio", "2011-10-10", "2000", "Argentina");
            insertarDatos("2", "Jesus", "2002-02-22", "5600", "Colombiana");
            insertarDatos("3", "Alejandra", "2004-01-07", "54300", "Americana");
            insertarDatos("4", "Elena", "2019-04-10", "35200", "Francesa");
        }



        public void mostrarDatos(TextBox numeroText, TextBox titularText, TextBox fechaText, TextBox saldoText, TextBox nacionalidadText, int fid)
        {
            try
            {
                string MyConnection2 = "datasource=localhost;port=3306;username=pjrg;password=pjrg";
                string Query = "select * from practica3.contactos where NumeroCuenta='" + fid + "';";

                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;

                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();

                while (MyReader2.Read())
                {
                    numeroText.Text = MyReader2["NumeroCuenta"].ToString();
                    titularText.Text = MyReader2["Titular"].ToString();
                    fechaText.Text = MyReader2["FechaApertura"].ToString();
                    saldoText.Text = MyReader2["Saldo"].ToString();
                    nacionalidadText.Text = MyReader2["Nacionalidad"].ToString();
                }

                MyConn2.Close();
            }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
        }



        public void insertarDatos(string numeroCuenta, string titular, string fecha, string saldo, string nacionalidad)
        {
            try
            { 
                string MyConnection2 = "datasource=localhost;port=3306;username=pjrg;password=pjrg";
                string Query = "insert into practica3.contactos(NumeroCuenta,Titular,FechaApertura,Saldo,Nacionalidad) values('" + numeroCuenta + "','" + titular + "','" + fecha + "','" + saldo + "','" + nacionalidad + "');";
 
                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;

                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();
                MyConn2.Close();
            }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
        }



        public void eliminarTodosLosDatos()
        {
            try
            {
                string MyConnection2 = "datasource=localhost;port=3306;username=pjrg;password=pjrg";
                string Query = "delete from practica3.contactos;";

                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;

                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();
                MyConn2.Close();
            }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
        }



        public int actualizarTamano()
        {
            int tam = 0;

            try
            {
                string MyConnection2 = "datasource=localhost;port=3306;username=pjrg;password=pjrg";
                string Query = "select * from practica3.contactos;";

                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;

                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();

                while (MyReader2.Read())
                {
                    tam++;
                }

                MyConn2.Close();
            }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }

            return tam;
        }



        public bool verificarNumero(TextBox numeroText)
        {
            bool resultado;

            if (numeroText.Text != null)
            {
                if(!numeroText.Text.All(char.IsDigit))
                {
                    resultado = false;
                }
                    else
                    {
                        resultado = true;
                    }
            }
                else
                {
                    resultado = false;
                }

            return resultado;
        }



        public bool verificarCadena(TextBox titularText)
        {
            bool resultado;

            if (titularText.Text != null)
            {
                if (titularText.Text.All(char.IsDigit))
                {
                    resultado = false;
                }
                    else
                    {
                        resultado = true;
                    }
            }
                else
                {
                    resultado = false;
                }

            return resultado;
        }



        public bool verificarFecha(TextBox fechaText)
        {
            bool resultado;

            if (fechaText.Text != null)
            {
                DateTime fecha;

                if (DateTime.TryParse(fechaText.Text, out fecha))
                {
                    resultado = true;
                }
                    else
                    {
                        resultado = false;
                    }
            }
                else
                {
                    resultado = false;
                }

            return resultado;
        }



        public bool verificarSaldo(TextBox saldoText)
        {
            bool resultado;
            float numero;

            if (saldoText.Text != null)
            {
                if (Single.TryParse(saldoText.Text, out numero))
                {
                    resultado = true;
                }
                    else
                    {
                        resultado = false;
                    }
            }
                else
                {
                    resultado = false;
                }

            return resultado;
        }
    }
}